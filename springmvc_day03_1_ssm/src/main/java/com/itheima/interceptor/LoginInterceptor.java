package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("************" + request.getContextPath() + "*********");
        Object username = request.getSession().getAttribute("username");
        if (username == null) {

            String path = request.getContextPath();
            response.sendRedirect(path + "/login.jsp");
            return false;
        } else {

            return true;
        }
    }

}
