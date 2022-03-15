package io.github.potatob6.Servlets;

import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Models.UserBean;
import io.github.potatob6.Wrapper.EncodingResponse;
import io.github.potatob6.Wrapper.EncodingWrapper;

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
        EncodingWrapper encodingWrapper = new EncodingWrapper(req);
        String username = encodingWrapper.getParameter("username");
        String pwd = encodingWrapper.getParameter("pwd");
        String nickname = encodingWrapper.getParameter("nickname");

        System.out.println("用户名："+username);
        System.out.println("密码:"+pwd);
        System.out.println("昵称:"+nickname);

        UserBean userBean = new UserBean();
        userBean.setUserID(username);
        userBean.setPwd(pwd);
        userBean.setNickname(nickname);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        boolean result = ourDatabase.addUser(userBean);
        EncodingResponse encodingResponse = new EncodingResponse(resp);
        resp.setContentType("text/html; charset=UTF-8");
        //TODO 跳转到注册成功的页面
        encodingResponse.println("添加用户"+result);
        resp.getOutputStream().close();
    }
}
