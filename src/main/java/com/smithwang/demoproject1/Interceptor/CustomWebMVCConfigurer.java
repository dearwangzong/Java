package com.smithwang.demoproject1.Interceptor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 拦截器的配置类
 */
@Configuration
public class CustomWebMVCConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(interceptor).addPathPatterns("/api/v1/user/list");
        registry.addInterceptor(twoInterceptor).addPathPatterns("/api/v1/user/list");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    @Autowired
    public  LoginInterceptor interceptor;

    @Autowired
    public  TwoInterceptor twoInterceptor;

//    @Bean
//    public  LoginInterceptor getLoginInterceptor(){
//        return  new LoginInterceptor();
//    }
}
