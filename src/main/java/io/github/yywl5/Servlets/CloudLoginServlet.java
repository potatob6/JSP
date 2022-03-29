package io.github.yywl5.Servlets;

import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Models.UserBean;
import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloudLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userid = req.getParameter("userID");
        String pwd = req.getParameter("pwd");
        UserBean userBean = new UserBean();
        userBean.setUserID(userid);
        OurDatabase ourDatabase = OurDatabase.getDataBase();
        UserBean userBean1 = ourDatabase.querySpecificUserByUserID(userBean);

        //这里是调试输出，到时候删掉
        if(userBean1 != null){
            if(userBean1.getPwd().equals(pwd)) {
                System.out.println("登录成功：用户名：" + userBean1.getUserID());
                System.out.println("        密码：" + userBean1.getPwd());
                System.out.println("        昵称:" + userBean1.getNickname());
                req.getSession().setMaxInactiveInterval(30*60);
                req.setAttribute("login", userBean1);
                req.getRequestDispatcher("upload.jsp")
                        .forward(req, resp);
                return;
            }else{
                System.out.println("密码错误");
                resp.setContentType("text/html; charset=utf-8");
                EncodingResponse encodingResponse = new EncodingResponse(resp);
                encodingResponse.println("密码错误");
                resp.sendRedirect("ManagerLoginError.jsp");
                return;
            }
        }else{
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            encodingResponse.println("无此用户");
        }
    }
}
