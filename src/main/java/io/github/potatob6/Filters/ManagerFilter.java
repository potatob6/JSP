package io.github.potatob6.Filters;

import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/deleteBook", "/AdminMainPage.jsp" , "/AllBorrows.jsp" , "/AllUsers.jsp", "/changeBook.jsp", "/changeBook_service",
                         "/changeUser.jsp", "/changeUser_service"})
public class ManagerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if(request.getSession().getAttribute("managerlogin")==null){
            ((HttpServletResponse)servletResponse).sendRedirect("./CloudManageadmin.jsp");
//            servletResponse.setContentType("text/html; charset=utf-8");
//            EncodingResponse encodingResponse = new EncodingResponse(((HttpServletResponse) servletResponse));
//            encodingResponse.println("管理员未登录");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
