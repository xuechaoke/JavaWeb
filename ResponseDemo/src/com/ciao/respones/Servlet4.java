package com.ciao.respones;


import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 2018/7/6/006.
 */
@WebServlet(name = "Servlet4",urlPatterns = "/response04")
public class Servlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        ServletContext servletContext = getServletContext();
        String filePath = servletContext.getRealPath("dl/"+fileName);

        response.setHeader("Content-Disposition","attachment;filename="+fileName);

        InputStream in = new FileInputStream(filePath);

//        byte [] b = new byte[1024];
//        int len;
        ServletOutputStream outputStream = response.getOutputStream();
//        while ((len=in.read(b))!=-1){
//            outputStream.write(b,0,len);
//        }
//        outputStream.close();
//        in.close();
//        IOUtils.copy(in,outputStream);
    }
}
