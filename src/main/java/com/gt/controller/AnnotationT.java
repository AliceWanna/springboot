package com.gt.controller;

import com.gt.bean.Person;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnnotationT {

//    @GetMapping("/setCookie")
//    public String setCookies(){
//
//    }\
    @PostMapping("/saveuser")
    public Person saveuser(Person person){
        return person;
    }


    @GetMapping("/args/{id}/{username}")
    public Map allArgs(@PathVariable("id") Integer id,
                       @PathVariable("username") String name,
                       @PathVariable Map<String,String> pv,
                       @RequestHeader("User-Agent") String userAgent,
                       @RequestHeader Map<String,String> header,
                       @RequestParam(value = "age",required = false) Integer age,
                       @RequestParam(value = "inters",required = false) List<String> inters,
                       @RequestParam Map<String,String> params,
                       @CookieValue("Idea-ef6d4613") String _cookie,
                       @CookieValue("Idea-ef6d4613") Cookie cookie){
        Map<String,Object> map = new HashMap<>();
        map.put("age",age);
        map.put("inters",inters);
        map.put("params",params);
        map.put("Idea-ef6d4613",_cookie);
        System.out.println(cookie.getName()+"===>"+cookie.getValue());

        return map;
    }


    @PostMapping("/save")
    public String getJsons(@RequestBody String _string){
        return _string;
    }




    @GetMapping("/reqHeader")
    public Map<String,Object> reqHeaders(@RequestHeader("Accept-Encoding") String encoding,
                                         @RequestHeader("Cookie") String cookie,
                                         @RequestHeader Map<String, Object> reqHeaders){
        Map<String, Object> map = new HashMap<>();
        map.put("Accept-Encoding",encoding);
        map.put("Cookie",cookie);
        map.put("RequestHeader",reqHeaders);
        return map;
    }


    @GetMapping("/car/{carName}/owner/{userName}")
    public Map<String, Object> carInfo(@PathVariable String carName,
                                       @PathVariable String userName,
                                       @PathVariable Map<String,String> mapGet){
        Map<String,Object> map = new HashMap<>();
        map.put("carname",carName);
        map.put("username",userName);
        map.put("map",mapGet);
        return map;
    }

    @GetMapping("/car")
    public Map<String,Object> formCar(@RequestParam("id") String id,
                                      @RequestParam("name") String name,
                                      @RequestParam Map<String,String> mapGet){
        HashMap<String, Object> map = new HashMap<>();
        map.put("car-id:",id);
        map.put("car-name",name);
        map.put("map-get",mapGet);
        return map;
    }

    //studentAndTeacher/sid;age=12/tid;age=32
    @GetMapping("studentAndTeacher/{sid}/{tid}")
    public Map<String,Object> matrix(@MatrixVariable(value = "age",pathVar = "sid")String sage,
                                     @MatrixVariable(value = "age",pathVar = "tid")String tage,
                                     @PathVariable("sid")String sid,
                                     @PathVariable("tid")String tid){
        Map<String, Object> map = new HashMap<>();
        map.put("student-age",sage);
        map.put("teacher-age",tage);
        map.put("sid",sid);
        map.put("tid",tid);
        return map;
    }

    @GetMapping("/cookie")
    public String getCookies(@CookieValue("Idea-ef6d4613") String c){
        return c;
    }
}
