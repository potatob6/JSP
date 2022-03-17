package io.github.yywl5.Servlets;

import io.github.potatob6.Wrapper.EncodingWrapper;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import io.github.potatob6.Models.OurDatabase;
/**
 * @author 星包客
 */

public class SecretChangeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet...");
        PrintStream out = new PrintStream(response.getOutputStream());
        response.setContentType("text/html;charSet=utf-8");
        out.println("请正常登录网页");
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost...");
        EncodingWrapper encodingWrapper = new EncodingWrapper(request);
        String username= encodingWrapper.getParameter("username");
        String password= encodingWrapper.getParameter("password");
        String password2= encodingWrapper.getParameter("password2");
        String errmsg = "";
        response.setContentType("text ml;charset=gb2312");
        try{
            OurDatabase editpasswordseek = OurDatabase.getDataBase();
//            editpasswordseek
            if (username==null || password ==null || password2 == null){
                response.sendRedirect("reSecretChange.jsp?errmsg=inforamtion error");
            }
            if(password.equals(password2)){
                //多判断条件, 即数据库中该密码与输入密码相等
                errmsg = "密码修改成功";
                request.setAttribute("errmsg",errmsg);
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }else{
                errmsg = "出错,请重新设置";
                request.setAttribute("errmsg",errmsg);
                response.sendRedirect("reSecretChange.jsp?errmsg=database error");
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }


    }

}
