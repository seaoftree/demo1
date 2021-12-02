package com.example.demo1.aop;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author a58
 */
public class AuthInterceptor implements HandlerInterceptor {
    private String name;
    public AuthInterceptor(String name) {
        this.name = name == null ? getClass().getName() : name;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("拦截器：" + request.getRequestURI());
        System.out.println("拦截器：" + response.getContentType());
        System.out.println("拦截器：" + ((HandlerMethod)handler).getMethod());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
    }
}
