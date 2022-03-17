package io.github.potatob6.Servlets;



import io.github.potatob6.Models.BorrowWithBookBean;
import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Calendar;
import java.util.Formatter;

/**
 * 借阅图书的Servlet
 */
public class BorrowBook extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userID = req.getParameter("login");
        int bookID = Integer.parseInt(req.getParameter("bookID"));
        System.out.println(bookID);
        BorrowWithBookBean borrowWithBookBean = new BorrowWithBookBean();
        borrowWithBookBean.setUserID(userID);
        borrowWithBookBean.setBookID(bookID);
        Calendar nowDay = Calendar.getInstance();
        Formatter formatter = new Formatter();
        formatter.format("%04d-%02d-%02d",
                nowDay.get(Calendar.YEAR),
                nowDay.get(Calendar.MONTH)+1,
                nowDay.get(Calendar.DAY_OF_MONTH));
        borrowWithBookBean.setBorrowDate(Date.valueOf(formatter.out().toString()));
        borrowWithBookBean.setTimeLimit(30) ;
        borrowWithBookBean.setReturnedDate(null);
        borrowWithBookBean.setOvertimeCharge(null);
        int count = 1; //留着更新Book库存用,数据库方法暂未写更新Book表

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        int result = ourDatabase.borrowBook(borrowWithBookBean);
        if(result != 0){
            System.out.println("借阅成功");
        }
        req.getRequestDispatcher("/JSP/borrow.jsp").forward(req, resp);
        resp.getOutputStream().close();

    }
}
