package com.gt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class errorController {

    @GetMapping("/mathError")
    public String mathError(){
        int i = 10/0;
        return "redirect:/main.html";
    }
}
