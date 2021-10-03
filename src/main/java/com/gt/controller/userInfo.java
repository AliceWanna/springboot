package com.gt.controller;

import com.gt.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userInfo {

    @Autowired
    private User user;

//    @RequestMapping("/user")
//    public User userInfo() {
//        return user;
//    }
}
