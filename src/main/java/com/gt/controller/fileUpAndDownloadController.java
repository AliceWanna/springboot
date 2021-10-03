package com.gt.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;


@Log4j2
@Controller
public class fileUpAndDownloadController {


    @PostMapping("/upFile")
    public String upFile(@RequestParam("username") String name,
                         @RequestParam("email") String email,
                         @RequestParam("one-file")MultipartFile oneFile,
                         @RequestParam("multiply-files")MultipartFile[] files) throws IOException {
        log.info("username:{}",name);
        log.info("email:{}",email);
        if(!oneFile.isEmpty()){
            oneFile.transferTo(new File("D:\\" + oneFile.getOriginalFilename()));
        }
        if(files.length>0){
            for (MultipartFile file : files) {
                file.transferTo(new File("D:\\" + file.getOriginalFilename()));
            }
        }
        return "redirect:main.html";
    }
}
