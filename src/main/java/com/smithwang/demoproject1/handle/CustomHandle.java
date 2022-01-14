package com.smithwang.demoproject1.handle;


import com.smithwang.demoproject1.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;


/**
 * 这是一个异常处理的类
 */
@RestControllerAdvice
public class CustomHandle {


    @ExceptionHandler(value = Exception.class)
    Object handleException(Exception e, HttpServletRequest request){
       return JsonData.fail("发生了意外的错误",e.getMessage());
    }
}
