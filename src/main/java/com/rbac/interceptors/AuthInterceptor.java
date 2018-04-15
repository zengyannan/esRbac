package com.rbac.interceptors;


import com.rbac.config.RbacConfig;
import com.rbac.entity.Admin;
import com.rbac.entity.Role;

import com.rbac.utils.CommonUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

import static com.sun.imageio.plugins.jpeg.JPEG.COM;

/**
 * Created by Ng on 2017/4/16.
 */

public class AuthInterceptor implements HandlerInterceptor {

    private List<String> excludeUrls;
    private boolean flag=false;
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession httpSession = httpServletRequest.getSession();
        Admin admin = (Admin)httpSession.getAttribute("user");
        Role role =admin.getRole();
        String url = httpServletRequest.getRequestURI();
        for (String excludeUrl:excludeUrls) {
            if(excludeUrl.equals(url)){
                return true;
            }
        }
        if(role.getRoleId()== RbacConfig.SUPER_ADMIN_ROLE_ID){
            return true;
        }
        String roleAuthAc = role.getRoleAuthAc();
        String[] authPaths= roleAuthAc.split(",");
        String[] modelAndAction =url.split("/");
        String currentPath =modelAndAction[1]+"-"+modelAndAction[2];
        for (String authPath: authPaths) {
            if(authPath.equals(currentPath)){
                flag=true;
            }
        }
        if(flag){
            return  true;
        }else {
            httpServletResponse.sendRedirect("/index/error");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }


    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludeUrls = excludeUrls;
    }
}
