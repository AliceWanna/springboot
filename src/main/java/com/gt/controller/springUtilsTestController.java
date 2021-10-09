package com.gt.controller;

import com.gt.bean.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class springUtilsTestController {


    @Autowired
    ApplicationContext context;

    @ResponseBody
    @GetMapping("/context")
    public Pet getPet(){
        if(!ObjectUtils.isEmpty(context)){
//            String[] names = context.getBeanDefinitionNames();
//            for(String name: names){
//                System.out.println(name);
//            }
            Pet pet1 = context.getBean("pet1", Pet.class);
            System.out.println(pet1.getClass());
            return pet1;
        }
        return null;
    }
}
