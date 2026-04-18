package com.sarni.spring01ioc;

import com.sarni.spring01ioc.controller.OrderController;
import com.sarni.spring01ioc.controller.impl.OrderControllerImpl;
import org.junit.jupiter.api.Test;

import static com.sarni.spring01ioc.proxy.Dynamic.DynamicProxy.getDynamicProxy;

public class ProxyTest {
    @Test
    public void testProxy(){
        OrderController dynamicProxy = (OrderController)getDynamicProxy(new OrderControllerImpl());
        dynamicProxy.getOrder();
    }
}
