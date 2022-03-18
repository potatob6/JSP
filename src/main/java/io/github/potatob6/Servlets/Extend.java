package io.github.potatob6.Servlets;

import io.github.potatob6.Models.BorrowBean;
import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Models.UserBean;
import io.github.potatob6.Wrapper.EncodingResponse;
import io.github.potatob6.Wrapper.EncodingWrapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 延迟借阅日期的方法
 */
@WebServlet(urlPatterns = "/extend")
public class Extend extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer borrowID = Integer.parseInt(req.getParameter("borrowID"));
        Integer duration = Integer.parseInt(req.getParameter("duration"));
        UserBean userBean = (UserBean)req.getSession().getAttribute("login");
        BorrowBean bean = new BorrowBean();
        bean.setBorrowID(borrowID);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        BorrowBean queryBean = (BorrowBean) ourDatabase.queryBean(bean, BorrowBean.class);
        if(queryBean==null){
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            encodingResponse.println("不存在此借阅");
            return;
        }
        queryBean.setTimeLimit(queryBean.getTimeLimit()+duration);
        boolean result = ourDatabase.updateBean(queryBean, BorrowBean.class, false);
        if(result==true){
            resp.sendRedirect("/JSP/ExtendSuccess.jsp");
            return;
        }
        resp.setContentType("text/html; charset=utf-8");
        EncodingResponse encodingResponse = new EncodingResponse(resp);
        encodingResponse.println("申请失败");
    }
}
