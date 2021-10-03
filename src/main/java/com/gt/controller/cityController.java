package com.gt.controller;

import com.gt.bean.city;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class cityController {

    @Autowired
    private com.gt.service.cityService cityService;

    @ResponseBody
    @GetMapping("/getCity")
    city getCityById(@RequestParam("id") int id){
        return cityService.getCityById(id);
    }
}
