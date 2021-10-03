package com.gt.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gt.bean.User;
import com.gt.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pageController {

    @Autowired
    private userService userService;

    @GetMapping("/userPage/{pageNo}")
    public String userPage(@PathVariable(name = "pageNo") long pageNo,
                           @RequestParam(value = "pageSize" ,defaultValue = "5") long pageSize,
                           Model model) {
        Page<User> page = userService.page(new Page<User>(pageNo, pageSize));
        long pages = page.getPages();
//        Page<User> page = userService.page(new Page<>(pageNo, pageSize));
//        Page<User> page = new Page<>();
//        page.setPageNo(pageNo);
//        page.setPageSize(pageSize);
//        Page<User> userPage = userService.myPage(pageNo, pageSize);
        model.addAttribute("page",page);
        model.addAttribute("pageNo",pageNo);
        return "table/dynamic_table";
    }
}
