package com.rbac.interceptors;

import com.rbac.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Ng on 2017/4/16.
 */
public class LoginInterceptor implements HandlerInterceptor {

    private String loginUrl;



    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession httpSession =httpServletRequest.getSession();
        Admin admin =(Admin)httpSession.getAttribute("user");
        String  url =httpServletRequest.getRequestURI();
        if(admin==null&&loginUrl.equals(url)){
            return true;
        }else if(admin==null && !loginUrl.equals(url)){
            httpServletResponse.sendRedirect("/admin/login");
            return false;
        }else if(admin!=null && loginUrl.equals(url)){
            httpServletResponse.sendRedirect("/index/index");
            return false;

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}
