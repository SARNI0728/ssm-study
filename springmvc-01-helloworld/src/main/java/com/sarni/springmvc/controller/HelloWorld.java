package com.sarni.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    // 测试注解中的method属性
    @RequestMapping(value = "/test01",method = RequestMethod.GET)
    public String test01(){
        return "test01方法执行了！！";
    }

    // 测试注解中的params属性
    /**
     * 请求参数：params = {"username","age"}
     * 1）、username：  表示请求必须包含username参数
     * 2）、age=18：   表示请求参数中必须包含age=18的参数
     * 3）、gender!=1：  表示请求参数中不能包含gender=1的参数
     */
    @RequestMapping(value = "/test02",params = {"username","age"})
    public String test02(){
        return "test02方法执行了！！";
    }

    //测试注解中的Consume属性
    @RequestMapping(value = "/test03",consumes = "application/json")
    //参数：consumes = "application/json" 表示请求体中的内容类型是application/json
    public String test03(){
        return "test03方法执行了！！";
    }

    //测试注解中的Produces属性
    @RequestMapping(value = "/test04",produces = "text/html")
    //参数：produces = "application/json" 表示响应体中的内容类型是text/html
    public String test04(){
        return "test04方法执行了！！";
    }
}
