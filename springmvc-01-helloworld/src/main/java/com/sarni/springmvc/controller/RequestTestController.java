package com.sarni.springmvc.controller;

import com.sarni.springmvc.pojo.Person;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class RequestTestController {
    @RequestMapping("/handle01")
    public String handle(String username,String password,String cellphone,Boolean agreement){
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("cellphone = " + cellphone);
        System.out.println("agreement = " + agreement);
        return "ok";
    }

    @RequestMapping("/handle02")
    public String handle02(@RequestParam("username") String name,
                           @RequestParam("password") String pwd,
                           @RequestParam("cellphone") String phone,
                           @RequestParam("agreement") Boolean agree){
        System.out.println("username = " + name);
        System.out.println("password = " + pwd);
        System.out.println("cellphone = " + phone);
        System.out.println("agreement = " + agree);
        return "ok";
    }

    @RequestMapping("/handle03")
    public String handle03(Person person){
        System.out.println(person);
        return "ok";
    }

    @RequestMapping("/handle04")
    public String handle04(@RequestHeader("sec-ch-ua-platform") String ua){
        System.out.println(ua);
        return ua;
    }

    @RequestMapping("/handle05")
    public String handle05(@CookieValue("username") String cookie){
        return cookie;
    }

    @RequestMapping("/handle06")
    public String handle06(Person person){
        return person.toString();
    }

    @RequestMapping("/handle07")
    public String handle07(@RequestBody Person person){
        //@RequestBody 注解表示请求体中的内容会被封装为Person对象
        System.out.println(person);
        return "ok";
    }

    @RequestMapping("/handle08")
    public String handle08(Person person,
    @RequestParam("headerImg") MultipartFile headerImgFile,
    @RequestPart("lifeImg") MultipartFile[] lifeImgFile) throws IOException {
        System.out.println(headerImgFile.getOriginalFilename());
        for (MultipartFile lifeImg : lifeImgFile) {
            System.out.println(lifeImg.getOriginalFilename());
        }
        String fileName = headerImgFile.getOriginalFilename();
        headerImgFile.transferTo(new File("/Users/sarni/JAVA后端学习/" + fileName));

        System.out.println(person);
        return person.toString();
    }

    @RequestMapping("/handle09")
    public String handle09(HttpEntity<String> httpEntity){
        System.out.println(httpEntity);
        return "ok";
    }
}
