package com.sarni.spring01ioc.controller;

import com.sarni.spring01ioc.pojo.Person;
import com.sarni.spring01ioc.service.UserService;
import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Data
@ToString
@Controller
public class userController {

    // 注入： 在使用Spring以后， 就不再需要我们自己手动创建对象了， 而是由Spring来帮我们创建对象
    // 在我们需要这一类的对象时，Spring会自动注入到我们需要的对象中
    @Autowired
    UserService userService;

    @Autowired
    Person sarni;

    @Autowired
    List<Person> personList;
}
