package com.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by wyw on 2018/2/8
 */
public class MyFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("========init=========");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("========doFilter前=========");

        String characterEncoding = filterConfig.getInitParameter("characterEncoding"); //编码格式
        servletRequest.setCharacterEncoding(characterEncoding);
        servletResponse.setCharacterEncoding(characterEncoding);
        servletResponse.setContentType("text/html;charset="+characterEncoding);

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        String path = request.getServletPath();
        String param = request.getQueryString();
        if(path != null && param != null){
            path = path + "?" + param;
        }
        System.out.println(path);

        filterChain.doFilter(servletRequest,servletResponse); //doFilter(ServletRequest request,ServletResponse response)把请求传给Filter链的下一个Filter，若当前Filter是链的最后一个，则把请求传给目标Servlet(或JSP)
        System.out.println("========doFilter后=========");
    }

    @Override
    public void destroy() {
        System.out.println("========destory=========");
        this.filterConfig = null;
    }
}
