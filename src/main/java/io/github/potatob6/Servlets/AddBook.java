package io.github.potatob6.Servlets;

import io.github.potatob6.Models.BookBean;
import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Wrapper.EncodingResponse;
import io.github.potatob6.Wrapper.EncodingWrapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.Calendar;
import java.util.Formatter;

/**
 * 添加图书的Servlet
 */
public class AddBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EncodingWrapper encodingWrapper = new EncodingWrapper(req);
        String bookID = encodingWrapper.getParameter("bookID");    //不需要提供bookID，自增
        String classID = encodingWrapper.getParameter("classID");
        String bookName = encodingWrapper.getParameter("bookName");
        String publisher = encodingWrapper.getParameter("publisher");
        BigDecimal originPrice = new BigDecimal(encodingWrapper.getParameter("originPrice"));
        int storageCount = Integer.parseInt(encodingWrapper.getParameter("storageCount"));

        BookBean bookBean = new BookBean();
        Calendar nowDay = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%04d-%02d-%02d",
                nowDay.get(Calendar.YEAR),
                nowDay.get(Calendar.MONTH)+1,
                nowDay.get(Calendar.DAY_OF_MONTH));

        bookBean.setBookID(Integer.parseInt(bookID));
        bookBean.setStorageDate(Date.valueOf(formatter.out().toString()));
        bookBean.setBookName(bookName);
        bookBean.setClassID(classID);
        bookBean.setPublisher(publisher);
        bookBean.setOriginPrice(originPrice);
        bookBean.setStorageCount(storageCount);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        boolean result = ourDatabase.insert(bookBean, BookBean.class, false);
        EncodingResponse encodingResponse = new EncodingResponse(resp);
        resp.setContentType("text/html; charset=UTF-8");
        encodingResponse.println("影响行数:"+result);
        resp.getOutputStream().close();
    }
}
