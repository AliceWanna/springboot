package com.gt.controller;

import com.gt.bean.User;
import com.gt.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class userController {

    @Autowired
    private userService userService;



    @ResponseBody
    @GetMapping("/allUser")
    public List<User> getUsers(){
        return userService.list();
    }
}
