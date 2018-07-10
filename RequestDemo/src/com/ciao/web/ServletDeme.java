package com.ciao.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2018/7/8/008.
 */
@WebServlet(name = "ServletDeme",urlPatterns = "/request01")
public class ServletDeme extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getContextPath());
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            System.out.println(s + ":" + request.getHeader(s));
        }
        System.out.println(request.getMethod());
        String localName = request.getLocalName();
        System.out.println(localName);

        System.out.println(request.getRequestURI());
        System.out.println(request.getRequestURL());

    }
}
