package com.smithwang.demoproject1.service;

import com.smithwang.demoproject1.domain.User;

import java.util.List;

public interface UserService {

    String login(User user);


    List<User> getUserList();
}
