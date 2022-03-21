package io.github.potatob6.Filters;

import io.github.potatob6.Wrapper.EncodingResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 检查是否登录
 */
@WebFilter(urlPatterns = {"/borrow",
        "/SecretChange.jsp", "/UserMainPage.jsp",
        "/SecretChangeServlet", "/borrow.jsp",
        "/extend", "/returnBook", "/sendForum"})
public class LoginedFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Object object = ((HttpServletRequest)servletRequest).getSession().getAttribute("login");
        if(object==null){
            //未登录
//            servletResponse.setContentType("text/html; charset=utf-8");
//            EncodingResponse encodingResponse = new EncodingResponse((HttpServletResponse) servletResponse);
//            encodingResponse.println("未登录");
//            servletResponse.getOutputStream().println("未登录");
            ((HttpServletResponse)servletResponse).sendRedirect("/JSP/login.jsp");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
