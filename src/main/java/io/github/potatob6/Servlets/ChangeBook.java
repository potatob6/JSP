package io.github.potatob6.Servlets;

import io.github.potatob6.Models.BookBean;
import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;

@WebServlet(urlPatterns = "/changeBook_service")
public class ChangeBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer bookID = Integer.parseInt(req.getParameter("bookID"));
        Integer classID = Integer.parseInt(req.getParameter("classID"));
        String bookName = req.getParameter("bookName");
        String publisher = req.getParameter("publisher");
        BigDecimal originPrice = new BigDecimal(req.getParameter("originPrice"));
        Date storageDate = Date.valueOf(req.getParameter("storageDate"));
        Integer storageCount = Integer.parseInt(req.getParameter("storageCount"));

        BookBean bookBean = new BookBean();
        bookBean.setBookID(bookID);
        bookBean.setClassID(classID);
        bookBean.setBookName(bookName);
        bookBean.setPublisher(publisher);
        bookBean.setOriginPrice(originPrice);
        bookBean.setStorageDate(storageDate);
        bookBean.setStorageCount(storageCount);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        boolean result = ourDatabase.updateBean(bookBean, BookBean.class, false);
        if(!result) {
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            encodingResponse.println("失败");
            return;
        }
        resp.sendRedirect("./AdminMainPage.jsp");
    }
}
