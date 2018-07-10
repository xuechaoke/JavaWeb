package com.ciao.respones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.annotation.Repeatable;

/**
 * Created by Administrator on 2018/7/6/006.
 */
@WebServlet(urlPatterns = "/response02")
public class ResponseDemo01 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //三秒后跳转
        /* response.setHeader("refresh","3;url=http://baidu.com");
        response.setStatus(200);*/
        //重定向
//       response.setHeader("location","http://baidu.com");
//       response.setStatus(302);
        //============上面代码的简化方式======================
//        response.sendRedirect("http://baidu.com");

    }
}
