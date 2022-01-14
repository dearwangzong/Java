package com.smithwang.demoproject1.service.impl;

import com.smithwang.demoproject1.domain.User;
import com.smithwang.demoproject1.mapper.UserMapper;
import com.smithwang.demoproject1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {


    public static Map<String,User> sessionId = new HashMap<>();

    @Autowired
    UserMapper mapper;

    @Override
    public String login(User user) {
        User user1 =  mapper.login(user);
        if (user1!=null){
            user1.setToken(UUID.randomUUID().toString());
            sessionId.put(user1.getToken(),user1);
            return  user1.getToken();
        }else{
            return  "";
        }


    }

    @Override
    public List<User> getUserList() {
        return mapper.listUser();
    }
}
