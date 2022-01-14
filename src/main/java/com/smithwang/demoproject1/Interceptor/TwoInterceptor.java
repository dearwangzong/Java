package com.smithwang.demoproject1.Interceptor;

import com.alibaba.fastjson.JSON;
import com.smithwang.demoproject1.domain.User;
import com.smithwang.demoproject1.service.impl.UserServiceImpl;
import com.smithwang.demoproject1.utils.JsonData;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@Component
public class TwoInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("TwoInterceptor=========PreHandle");

         return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("TwoInterceptor=========postHandle");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("TwoInterceptor=========afterCompletion");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
