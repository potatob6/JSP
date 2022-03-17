package io.github.yywl5.Servlets;

import io.github.potatob6.Wrapper.EncodingWrapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author 星包客
 */
public class SecretChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet...");
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost...");
        EncodingWrapper encodingWrapper = new EncodingWrapper(request);
        String username= encodingWrapper.getParameter("username");
        String password= encodingWrapper.getParameter("password");
        String password2= encodingWrapper.getParameter("password2");


    }

}
