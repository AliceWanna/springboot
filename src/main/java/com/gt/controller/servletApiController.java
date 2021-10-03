package com.gt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class servletApiController {

    /*
    Map<String,Object> map,  Model model, HttpServletRequest request 都是可以给request域中放数据，
    request.getAttribute();
     */
    @GetMapping("/goto")
    public String gotoApiController(HttpServletRequest request,
                                    Model model,
                                    Map<String,Object> map){
        request.setAttribute("req-key",111 );
        model.addAttribute("model-key",222 );
        map.put("map-key",333 );
        return "forward:/main";
    }

    @ResponseBody
    @GetMapping("/success")
    public Map getRequest (@RequestAttribute("req-key") String req_key,
                           @RequestAttribute("model-key") String model_key,
                           @RequestAttribute("map-key") String map_key){
        Map<String,Object> map = new HashMap<>();
        map.put("req-key",req_key);
        map.put("model-key",model_key);
        map.put("map-key",map_key);
        return map;
    }
}
