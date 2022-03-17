package io.github.potatob6.Servlets;

import io.github.potatob6.Models.BookClassBean;
import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookClass extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        int classID = Integer.parseInt(req.getParameter("classID")); 不需提供classID，自增
        String className = req.getParameter("className");
        System.out.println("分类类型："+className);
        BookClassBean bookClassBean = new BookClassBean();
//        bookClassBean.classID = classID;
        bookClassBean.className = className;
        OurDatabase ourDatabase = OurDatabase.getDataBase();
        boolean result = ourDatabase.insert(bookClassBean, BookClassBean.class, true);
//        boolean result = ourDatabase.addBookClass(bookClassBean);

        EncodingResponse encodingResponse = new EncodingResponse(resp);
        resp.setContentType("text/html; charset=UTF-8");
        encodingResponse.println("影响行数："+result);
        resp.getOutputStream().close();
    }
}
