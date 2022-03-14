package io.github.potatob6.Servlets;

import io.github.potatob6.Models.BookBean;
import io.github.potatob6.Models.OurDatabase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Formatter;

/**
 * 添加图书的Servlet
 */
public class AddBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
        String bookID = req.getParameter("bookID");
        String classID = req.getParameter("classID");
        String bookName = req.getParameter("bookName");
        System.out.println("bookName:"+bookName);
        String publisher = req.getParameter("publisher");
        BigDecimal originPrice = new BigDecimal(req.getParameter("originPrice"));
        int storageCount = Integer.parseInt(req.getParameter("storageCount"));

        BookBean bookBean = new BookBean();
        Calendar nowDay = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%04d-%02d-%02d",
                nowDay.get(Calendar.YEAR),
                nowDay.get(Calendar.MONTH)+1,
                nowDay.get(Calendar.DAY_OF_MONTH));

        bookBean.setStorageDate(Date.valueOf(formatter.out().toString()));
        bookBean.setBookID(bookID);
        bookBean.setBookName(bookName);
        bookBean.setClassID(classID);
        bookBean.setPublisher(publisher);
        bookBean.setOriginPrice(originPrice);
        bookBean.setStorageCount(storageCount);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        boolean result = ourDatabase.addBook(bookBean);
    }
}