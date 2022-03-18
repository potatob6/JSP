package io.github.potatob6.Servlets;



import io.github.potatob6.Models.*;
import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(urlPatterns = "/borrowBook")
public class BorrowBook extends HttpServlet {

    @Override
    protected void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer bookID = Integer.parseInt(req.getParameter("bookID"));
        BookBean bookBean = new BookBean();
        UserBean userBean = (UserBean)req.getSession().getAttribute("login");
        bookBean.setBookID(bookID);
        OurDatabase ourDatabase = OurDatabase.getDataBase();

        synchronized (BorrowBook.class) {
            BookBean bean = (BookBean) ourDatabase.queryBean(bookBean, BookBean.class);
            if(bean==null){
                resp.setContentType("text/html; charset=utf-8");
                EncodingResponse encodingResponse = new EncodingResponse(resp);
                encodingResponse.println("未找到书籍");
                return;
            }
            if(bean.getStorageCount()==0){
                resp.setContentType("text/html; charset=utf-8");
                EncodingResponse encodingResponse = new EncodingResponse(resp);
                encodingResponse.println("书籍无库存");
                return;
            }
            bean.setStorageCount(bean.getStorageCount()-1);
            ourDatabase.updateBean(bean, BookBean.class, false);
        }

        BorrowBean borrowBean = new BorrowBean();
        borrowBean.setBookID(bookID);
        borrowBean.setUserID(userBean.getUserID());
        borrowBean.setTimeLimit(30);
        ourDatabase.insert(borrowBean, BorrowBean.class, true);
        resp.sendRedirect("/JSP/borrow.jsp");
    }

    @Override
    protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String userID = req.getParameter("login");
//        int bookID = Integer.parseInt(req.getParameter("bookID"));
//        System.out.println(bookID);
//        BorrowWithBookBean borrowWithBookBean = new BorrowWithBookBean();
//        borrowWithBookBean.setUserID(userID);
//        borrowWithBookBean.setBookID(bookID);
//        Calendar nowDay = Calendar.getInstance();
//        Formatter formatter = new Formatter();
//        formatter.format("%04d-%02d-%02d",
//                nowDay.get(Calendar.YEAR),
//                nowDay.get(Calendar.MONTH)+1,
//                nowDay.get(Calendar.DAY_OF_MONTH));
//        borrowWithBookBean.setBorrowDate(Date.valueOf(formatter.out().toString()));
//        borrowWithBookBean.setTimeLimit(30) ;
//        borrowWithBookBean.setReturnedDate(null);
//        borrowWithBookBean.setOvertimeCharge(null);
//        int count = 1; //留着更新Book库存用,数据库方法暂未写更新Book表
//
//        OurDatabase ourDatabase = OurDatabase.getDataBase();
//        int result = ourDatabase.borrowBook(borrowWithBookBean);
//        if(result != 0){
//            System.out.println("借阅成功");
//        }
//        req.getRequestDispatcher("/JSP/borrow.jsp").forward(req, resp);
//        resp.getOutputStream().close();

    }
}
