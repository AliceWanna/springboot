package com.gt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hellow {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hellow";
    }
}
