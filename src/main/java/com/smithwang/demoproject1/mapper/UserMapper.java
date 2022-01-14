package com.smithwang.demoproject1.mapper;

import com.smithwang.demoproject1.domain.User;
import org.springframework.stereotype.Repository;
import sun.swing.BakedArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserMapper {

    private  static  Map<Integer, User> userMap = new HashMap<>();

    static {
        userMap.put(1,new User(1,"Jack","123"));
        userMap.put(2,new User(2,"xdClass","12344"));
        userMap.put(3,new User(3,"Smith","qqwe"));
        userMap.put(4,new User(4,"Tom","xcxc"));
    }


    public  User login(User user){
        List<User> users = new ArrayList<>();
        users.addAll(userMap.values());

//        boolean success=  users.stream().anyMatch(x->x.getName().equals(user.getName())&&x.getPassword().equals(user.getPassword()));
         List<User> user1= users.stream().filter(x->x.getName().equals(user.getName())&&x.getPassword().equals(user.getPassword()))
                 .collect(Collectors.toList());
        return  user1.size()>0?user1.get(0):null;
    }


    public  List<User> listUser(){
        List<User> users = new ArrayList<>();

        users.addAll(userMap.values());

        return  users;
    }

}
