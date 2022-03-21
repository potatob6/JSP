package io.github.yywl5.Servlets;

import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Wrapper.EncodingResponse;
import io.github.yywl5.Models.ManagerBean;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class ManagerMent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userID");
        String pwd = request.getParameter("pwd");
        ManagerBean managerbean = new ManagerBean();
        managerbean.setUserID(userid);
        OurDatabase ourDatabase = OurDatabase.getDataBase();
        ManagerBean managerbean1 = ourDatabase.querySpecificManagerByUserID(managerbean);
        if(managerbean1 != null){
            if(managerbean1.getPwd().equals(pwd)) {
                System.out.println("登录成功：用户名：" + managerbean1.getUserID());
                System.out.println("        密码：" + managerbean1.getPwd());
                System.out.println("        昵称:" + managerbean1.getNickname());
                request.getSession().setMaxInactiveInterval(30*60);
                request.getSession().setAttribute("managerlogin", managerbean1);
                response.sendRedirect("./AdminMainPage.jsp");
                return;
            }else{
                System.out.println("密码错误");
                response.setContentType("text/html; charset=utf-8");
                EncodingResponse encodingResponse = new EncodingResponse(response);
                encodingResponse.println("密码错误");
                return;
            }
        }else{
            response.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(response);
            encodingResponse.println("无此用户");
        }
    }
}
