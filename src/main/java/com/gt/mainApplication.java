package com.gt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@ServletComponentScan(basePackages = "com.gt.myServlet")
@MapperScan("com.gt.Mapper")
@SpringBootApplication
public class mainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(mainApplication.class, args);
        String[] beanNamesForType = run.getBeanNamesForType(WebMvcConfigurer.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }
    }
}
