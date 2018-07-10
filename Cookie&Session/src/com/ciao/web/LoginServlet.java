package com.ciao.web;

import com.ciao.bean.User;
import com.ciao.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/8/008.
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //标识是否记住用户名
        String flag = request.getParameter("remember");
        //客户端验证码
        String code = request.getParameter("code");
        //服务器验证码
        String code_session = (String) request.getSession().getAttribute("code_session");
        //用户名
        String userName = request.getParameter("userName");
        //密码
        String passWord = request.getParameter("passWord");
        UserService userService = new UserService();
        //查询返回的user
        User user = userService.login(userName,passWord);
        //如果服务器验证码等于服务器验证码
        if (code.equalsIgnoreCase(code_session)) {
            //验证用户名密码是否正确
            if (user!=null) {
                //正确
                Cookie cookie = new Cookie("username",user.getuserName());

                cookie.setPath(request.getContextPath());
                if("true".equals(flag)){
                    cookie.setMaxAge(60*60);
                }else {
                    cookie.setMaxAge(0);
                }
                    response.addCookie(cookie);
                request.setAttribute("user",user);
                request.getRequestDispatcher("welcome.jsp").forward(request,response);
                //用户名或密码错误
            }else {
                request.setAttribute("msg","用户名或者密码错误！");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            //验证码错误
        }else {
            request.setAttribute("msg","验证码输入错误！");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
