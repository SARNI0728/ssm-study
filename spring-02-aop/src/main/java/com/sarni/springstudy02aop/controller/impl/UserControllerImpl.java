package com.sarni.springstudy02aop.controller.impl;

import com.sarni.springstudy02aop.controller.UserController;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserControllerImpl implements UserController {
    @Override
    public void login(String acc, String pwd) {
        System.out.println("登陆方法执行");
    }

    @Override
    public int getCurrentUserId(int id) {
        return id + 1;
    }
}
