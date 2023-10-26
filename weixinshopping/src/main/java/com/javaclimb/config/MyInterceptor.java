package com.javaclimb.config;

import com.javaclimb.common.Common;
import com.javaclimb.entity.UserInfo;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
* 全局拦截器
* 如果没有登录，重定向到登录页
* 返回true就继续执行后面的请求，返回false中断后面的请求，重定向到登录页
* */
public class MyInterceptor implements HandlerInterceptor {
    //所有访问后台的请求先要从这里路过
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute(Common.USER_INFO);
        if (userInfo==null){
            // 重定向到登录页
            response.sendRedirect("/end/page/login.html");
            return false;
        }
        return true;
    }
}
