package com.sarni.spring01ioc.controller.impl;

import com.sarni.spring01ioc.controller.OrderController;

public class OrderControllerImpl implements OrderController {
    @Override
    public void getOrder() {
        System.out.println("getOrder方法执行了···");
    }
}
