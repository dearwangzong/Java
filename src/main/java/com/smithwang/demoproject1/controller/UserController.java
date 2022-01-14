package com.smithwang.demoproject1.controller;


import com.smithwang.demoproject1.domain.User;
import com.smithwang.demoproject1.service.UserService;
import com.smithwang.demoproject1.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {


    @Autowired
    UserService service;


//    @PostMapping("/login")
//    public Object Login(String userName,String passWd){
//
//        System.out.println("UserName:"+userName+"|PassWord ："+passWd);
//
//        return JsonData.success(true);
//    }

    @PostMapping("/login")
    public JsonData Login(@RequestBody User user){

        System.out.println("UserName:"+user.getName()+"|PassWord ："+user.getPassword());

        String token = service.login(user);
        boolean checkResult = StringUtils.hasText(token);
        if (checkResult){
            return JsonData.success(token);
        }else{
            return JsonData.fail("账号/密码错误!","");
        }
//
//        if (){
//            return JsonData.success(user.getToken());
//        } else{
//            return JsonData.fail("账号/密码错误!","");
//        }


    }

    @GetMapping("/list")
    public Object getUserList(){
        return JsonData.success(service.getUserList());
    }




}
