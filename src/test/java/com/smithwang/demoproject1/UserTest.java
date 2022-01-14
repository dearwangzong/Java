package com.smithwang.demoproject1;

import com.smithwang.demoproject1.controller.UserController;
import com.smithwang.demoproject1.domain.User;
import com.smithwang.demoproject1.utils.JsonData;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoProject1Application.class})
public class UserTest {

    @Autowired
    UserController controller;


    @Test
    public void LoginTest(){
        User user = new User();
        user.setId(1);
        user.setName("Smith");
        user.setPassword("qqwe");


        JsonData jsonData = controller.Login(user);

        System.out.println(jsonData.getData());

        TestCase.assertEquals(true,jsonData.getData());
    }

}
