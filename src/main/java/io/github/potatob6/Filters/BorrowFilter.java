package io.github.potatob6.Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/borrowBook")
public class BorrowFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Object login = ((HttpServletRequest)servletRequest).getSession().getAttribute("login");
        if(login==null){
            ((HttpServletResponse)servletResponse).sendRedirect("/JSP/login.jsp");
            return;
        }
        String bookID = servletRequest.getParameter("bookID");
        if(bookID==null){
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
