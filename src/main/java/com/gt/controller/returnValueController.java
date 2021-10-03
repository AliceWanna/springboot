package com.gt.controller;

import com.gt.bean.computer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class returnValueController {

    @GetMapping("/return/computer")
    @ResponseBody
    public computer getComputer() {
        return new computer(1111,"Legion",8000.00,85);
    }
}
