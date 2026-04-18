package com.sarni.springstudy02aop;

import com.sarni.springstudy02aop.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringStudy02AopApplicationTests {
    @Autowired
    UserController userController;

    @Test
    void testLogAspectMethod() {
        userController.login("root","admin123");
        System.out.println("==========");

        int currentUserId = userController.getCurrentUserId(1);
        System.out.println("方法执行，得到了返回结果：" + currentUserId);
    }

}
