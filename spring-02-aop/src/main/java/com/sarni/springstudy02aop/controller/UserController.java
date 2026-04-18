package com.sarni.springstudy02aop.controller;

import org.springframework.stereotype.Controller;

@Controller
public interface UserController {
    void login(String acc, String pwd);

    int getCurrentUserId(int id);
}
