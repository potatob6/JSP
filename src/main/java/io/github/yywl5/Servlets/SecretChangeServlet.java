package io.github.yywl5.Servlets;

import io.github.potatob6.Models.UserBean;
import io.github.potatob6.Wrapper.EncodingResponse;
import io.github.potatob6.Wrapper.EncodingWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.sql.SQLException;

import io.github.potatob6.Models.OurDatabase;
/**
 * @author 星包客
 */

@WebServlet(urlPatterns = "/JSP/SecretChangeServlet")
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
        EncodingResponse encodingResponse = new EncodingResponse(response);
        String originPassword= encodingWrapper.getParameter("originPassword");
        String password= encodingWrapper.getParameter("password");
        String password2= encodingWrapper.getParameter("password2");
        String errmsg = "";
        if(!password.equals(password2)) {
            response.setContentType("text/html; charset=utf-8");
            encodingResponse.println("两次密码不一致");
            return;
        }
        response.setContentType("text ml;charset=gb2312");
        try{
            UserBean userBean = new UserBean();
            userBean.setUserID(username);
            OurDatabase EditPassword = OurDatabase.getDataBase();
            userBean=EditPassword.querySpecificUserByUserID(userBean);
            System.out.println(userBean.userID);
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
        UserBean userBean = (UserBean) request.getSession().getAttribute("login");
        OurDatabase ourDatabase = OurDatabase.getDataBase();
        UserBean newUserBean = (UserBean) ourDatabase.copyBean(userBean, UserBean.class);
        newUserBean.setPwd(password);
        UserBean userBean_old = ourDatabase.querySpecificUserByUserID(userBean);
        String real_old_pwd = userBean_old.getPwd();
        if(!real_old_pwd.equals(originPassword)) {
            response.setContentType("text/html; charset=utf-8");
            encodingResponse.println("原密码错误");
            return;
        }
        if(real_old_pwd.equals(password)) {
            response.setContentType("text/html; charset=utf-8");
            encodingResponse.println("旧密码不能与新密码一致");
            return;
        }
        boolean result = ourDatabase.updateBean(newUserBean, UserBean.class, false);
        if(result){
            response.sendRedirect("/JSP/PasswordChangeSuccess.jsp");
            return;
        }
        response.setContentType("text/html; charset=utf-8");
        encodingResponse.println("更改密码失败");
    }

}
