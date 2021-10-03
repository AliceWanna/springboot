package com.gt.controller;

import com.gt.bean.computer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


//@Controller
@RestController
public class paramsController {

    @PostMapping("/saveComputer")
    public computer getcomputer(computer c){
        return c;
    }


//    @GetMapping("ServletApi")
//    public String putMap(HttpServletRequest request,
//                         Model model,
//                         Map map){
//        request.setAttribute("")
//    }
}
