package io.github.potatob6.Servlets;

import io.github.potatob6.Models.ForumBean;
import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Models.UserBean;
import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/sendForum")
public class SendForum extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserBean userBean = (UserBean) req.getSession().getAttribute("login");
        String title = req.getParameter("title");
        String content = req.getParameter("content");
        if(title == null || content == null) {
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            resp.setStatus(403);
            encodingResponse.println("非法请求");
            return;
        }

        ForumBean forumBean = new ForumBean();
        forumBean.setUserID(userBean.getUserID());
        forumBean.setTitle(title);
        forumBean.setContent(content);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        boolean result = ourDatabase.insert(forumBean, ForumBean.class, true);
        if(!result){
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            resp.setStatus(403);
            encodingResponse.println("失败");
            return;
        }

        resp.sendRedirect("./forum.jsp");
    }
}
