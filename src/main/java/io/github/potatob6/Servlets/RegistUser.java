package io.github.potatob6.Servlets;

import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Models.UserBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户注册Servlet
 */
public class RegistUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String username = req.getParameter("username");
        String pwd = req.getParameter("pwd");
        String nickname = req.getParameter("nickname");

        UserBean userBean = new UserBean();
        userBean.setUserID(username);
        userBean.setPwd(pwd);
        userBean.setNickname(nickname);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        boolean result = ourDatabase.addUser(userBean);
        System.out.println("添加用户"+result);
        resp.getWriter().write("添加用户"+result);
    }
}
