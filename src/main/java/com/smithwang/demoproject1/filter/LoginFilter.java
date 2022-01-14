package com.smithwang.demoproject1.filter;


import com.alibaba.fastjson.JSON;
import com.smithwang.demoproject1.domain.User;
import com.smithwang.demoproject1.service.impl.UserServiceImpl;
import com.smithwang.demoproject1.utils.JsonData;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/api/v1/video_Order/*",filterName = "videoOrderFilter")
public class LoginFilter implements Filter {

    /**
     * 容器加载
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       System.out.println("Init_LoginFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("doFilter_LoginFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpServletResponse response= (HttpServletResponse) servletResponse;

        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)){
            token = request.getParameter("token");
        }

        if (!StringUtils.hasText(token)){
            //用户未登陆
            JsonData jsonData =  JsonData.fail(false,"用户未登陆，请先进行登录");
            renderJson(response,JSON.toJSONString(jsonData));
            return;
        }else{
            //确认当前的Token是否为有效Token
            User user = UserServiceImpl.sessionId.get(token);
            if (user!=null){
                //该干嘛干嘛
                filterChain.doFilter(servletRequest,servletResponse);
            }else{
                //Token失效或者压根没卵用
                JsonData jsonData =  JsonData.fail(false,"当前Token无效");
                renderJson(response,JSON.toJSONString(jsonData));
                return;
            }

        }
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

    /**
     * 容器销毁
     */
    @Override
    public void destroy() {
        System.out.println("destroy_LoginFilter");
    }
}
