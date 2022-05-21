package com.mm.mmcar.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author 茂茂
 * @create 2022-05-18 14:48
 */
@WebFilter(urlPatterns = {"/car/*", "/admin/*", "/main/*","/user/*"}, filterName = "securityRequestFilter")
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //取出sesion进行过滤,判断是否登录过,
        HttpSession session = request.getSession(false);
        if (session.getAttribute("userInfo") != null) {
            filterChain.doFilter(request, response);
        } else {
            //未登录转发至登录页面
            request.getRequestDispatcher("/").forward(request,response);
        }
    }
}