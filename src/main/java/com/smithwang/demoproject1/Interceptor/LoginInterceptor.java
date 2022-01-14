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
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("LoginInterceptor=========PreHandle");

//        String token = request.getHeader("token");
//        if (!StringUtils.hasText(token)){
//            token = request.getParameter("token");
//        }
//
//        if (!StringUtils.hasText(token)){
//            //用户未登陆
//            JsonData jsonData =  JsonData.fail(false,"用户未登陆，请先进行登录");
//            renderJson(response, JSON.toJSONString(jsonData));
//            return false;
//        }else{
//            //确认当前的Token是否为有效Token
//            User user = UserServiceImpl.sessionId.get(token);
//            if (user!=null){
//                //该干嘛干嘛
////                filterChain.doFilter(servletRequest,servletResponse);
//                return true;
//            }else{
//                //Token失效或者压根没卵用
//                JsonData jsonData =  JsonData.fail(false,"当前Token无效");
//                renderJson(response,JSON.toJSONString(jsonData));
//                return false;
//            }
//        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    private void renderJson(HttpServletResponse response,String json){
        //设定编码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        //在Jdk8以上有个新语法，Try里面（）会自动关闭
        try(PrintWriter writer = response.getWriter()){
            writer.println(json);
        }catch (Exception ex){

        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor=========postHandle");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LoginInterceptor=========afterCompletion");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
