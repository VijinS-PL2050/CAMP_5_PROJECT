package com.global.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class RestrictionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");

        if (isLoggedIn == null || !isLoggedIn) {
        	System.out.println("kjhgfdjbhv");
            response.sendRedirect(request.getContextPath() + "/login/user");
            return false;
        }

        return true;
    }
}

