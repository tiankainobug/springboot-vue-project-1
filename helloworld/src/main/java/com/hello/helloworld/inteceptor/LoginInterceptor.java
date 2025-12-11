package com.hello.helloworld.inteceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 功能：
 * 作者：田凯
 * 日期：2025/12/11 17:32
 **/
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("该请求进入了拦截器...");
        return true;
    }
}
