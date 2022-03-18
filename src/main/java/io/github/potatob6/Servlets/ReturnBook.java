package io.github.potatob6.Servlets;

import io.github.potatob6.Models.BookBean;
import io.github.potatob6.Models.BorrowBean;
import io.github.potatob6.Models.OurDatabase;
import io.github.potatob6.Models.UserBean;
import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.print.Book;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.StringTokenizer;

@WebServlet(urlPatterns = "/returnBook")
public class ReturnBook extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer borrowID = Integer.parseInt(req.getParameter("borrowID"));
        BorrowBean bean = new BorrowBean();
        UserBean loginedUser = (UserBean) req.getSession().getAttribute("login");
        bean.setBorrowID(borrowID);

        OurDatabase ourDatabase = OurDatabase.getDataBase();
        BorrowBean queryBorrow = (BorrowBean) ourDatabase.queryBean(bean, BorrowBean.class);
        if(queryBorrow==null){
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            encodingResponse.println("找不到此ID");
            return;
        }
        if(!queryBorrow.userID.equals(loginedUser.userID)){
            //权限错误
            resp.setStatus(403);
            return;
        }
        BookBean bookBean = new BookBean();
        bookBean.setBookID(queryBorrow.getBookID());
        BookBean queryBookBean = (BookBean) ourDatabase.queryBean(bookBean, BookBean.class);
        if(queryBookBean==null){
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            encodingResponse.println("错误");
            return;
        }
        queryBookBean.setStorageCount(queryBookBean.getStorageCount()+1);
        boolean result1 = ourDatabase.updateBean(queryBookBean, BookBean.class, false);
        if(result1==false) {
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            encodingResponse.println("错误");
            return;
        }
        //设置当前时间
        queryBorrow.setReturnedDate(ourDatabase.getNowDate());

        //计算超时收费
        Calendar nowCalendar = Calendar.getInstance();
        Calendar borrowCalendar = Calendar.getInstance();
        StringTokenizer strTok = new StringTokenizer(queryBorrow.getBorrowDate().toString(), "-");
        borrowCalendar.set(Calendar.YEAR, Integer.parseInt(strTok.nextToken()));
        borrowCalendar.set(Calendar.MONTH, Integer.parseInt(strTok.nextToken())-1);
        borrowCalendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(strTok.nextToken()));
        int day = (int) ((nowCalendar.getTimeInMillis() - borrowCalendar.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        //每超时10天加收4.5元
        double overTimeCharge = (day - queryBorrow.getTimeLimit()) * 5.5;
        if(overTimeCharge<0) overTimeCharge = 0;
        BigDecimal bigDecimal = new BigDecimal(overTimeCharge);
        queryBorrow.setOvertimeCharge(bigDecimal);
        boolean result = ourDatabase.updateBean(queryBorrow, BorrowBean.class, false);
        if(!result) {
            resp.setContentType("text/html; charset=utf-8");
            EncodingResponse encodingResponse = new EncodingResponse(resp);
            encodingResponse.println("归还失败");
            return;
        }
        resp.sendRedirect("/JSP/borrow.jsp");
    }
}
