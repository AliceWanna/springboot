package com.gt;

import com.gt.bean.Pet;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

@ServletComponentScan(basePackages = "com.gt.myServlet")
@MapperScan("com.gt.Mapper")
@SpringBootApplication
public class mainApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(mainApplication.class, args);
        Pet pet1 = run.getBean("pet1", Pet.class);
        System.out.println(pet1);
    }
}
