package com.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by wyw on 2018/2/26
 */
public class MyFilter2 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("========init2=========");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========doFilter2前=========");
        filterChain.doFilter(servletRequest,servletResponse); //doFilter(ServletRequest request,ServletResponse response)把请求传给Filter链的下一个Filter，若当前Filter是链的最后一个，则把请求传给目标Servlet(或JSP)
        System.out.println("========doFilter2后=========");
    }

    @Override
    public void destroy() {
        System.out.println("========destory2=========");
    }
}
