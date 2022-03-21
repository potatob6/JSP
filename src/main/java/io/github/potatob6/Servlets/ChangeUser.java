package io.github.potatob6.Servlets;

import io.github.potatob6.Models.BookBean;
import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Models.UserBean;
import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet(urlPatterns = "/changeUser_service")
public class ChangeUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userID = req.getParameter("userID");
        String pwd = req.getParameter("pwd");
        String nickname = req.getParameter("nickname");
        Integer isVIP = Integer.parseInt(req.getParameter("isVIP"));
        String cardID = req.getParameter("cardID");
        BigDecimal balance = new BigDecimal(req.getParameter("balance"));

        UserBean userBean = new UserBean();
        userBean.setUserID(userID);
        userBean.setPwd(pwd);
        userBean.setNickname(nickname);
        userBean.setVIP(isVIP);
        userBean.setCardID(cardID);
        userBean.setBalance(balance);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        boolean result = ourDatabase.updateBean(userBean, UserBean.class, false);
        if(!result) {
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            encodingResponse.println("失败");
            return;
        }
        resp.sendRedirect("./AllUsers.jsp");
    }
}
