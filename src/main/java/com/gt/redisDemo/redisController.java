package com.gt.redisDemo;


import com.gt.Utils.randomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/redis")
public class redisController {

    @ResponseBody
    @PostMapping("/kill")
    public String kill(@RequestParam("pid")String pid){
        String uid = randomUtils.randomCode(6);
        boolean doKill = killdemo1.doKill(uid, pid);
        if (doKill) {
            return "success";
        }
        else {
            return "failed";
        }
    }
}
