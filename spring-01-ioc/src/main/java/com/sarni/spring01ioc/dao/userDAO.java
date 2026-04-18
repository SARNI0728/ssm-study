package com.sarni.spring01ioc.dao;

import com.sarni.spring01ioc.pojo.Dog;
import org.springframework.stereotype.Repository;

@Repository
public class userDAO {

    Dog dog;

    public userDAO(Dog dog) {
        System.out.println("带有狗参数的 userDAO 被创建了");
    }
}
