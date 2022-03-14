package io.github.potatob6.Filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * 添加书籍过滤器
 */
public class AddBookFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 过滤条件至少要有书号,分类ID,书名,出版社,价格,数量
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String bookID = httpServletRequest.getParameter("bookID");
        String classID = httpServletRequest.getParameter("classID");
        String bookName = httpServletRequest.getParameter("bookName");
        String publisher = httpServletRequest.getParameter("publisher");
        String originPrice = httpServletRequest.getParameter("originPrice");
        String storageCount = httpServletRequest.getParameter("storageCount");

        if(bookID == null || classID == null || bookName == null || publisher == null || originPrice == null || storageCount == null) {
            //条件不充分
            System.out.println("条件不充分");
            System.out.println("bookID:"+bookID);
            System.out.println("classID:"+classID);
            System.out.println("bookName:"+bookName);
            System.out.println("publisher:"+publisher);
            System.out.println("originPrice:"+originPrice);
            System.out.println("storageCount:"+storageCount);
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
