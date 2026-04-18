package com.sarni.spring01ioc.pojo;

import lombok.Data;

@Data
public class BeanLifeCircleTestPojo {
    // 本类用于测试Bean的声明周期。
    // 详细来说，Bean的生命周期有两个需要注意：
    // 初始化以及销毁。
    // 完整的生命周期：
    // 先对组件进行初始化，然后对组件中需要自动注入的注入，
    // 然后开始执行生命周期中初始化指定的方法

    // 属性1
    private String attribute1;
    // 属性2
    private String attribute2;

    public BeanLifeCircleTestPojo(){
        System.out.println("生命周期测试类的构造器执行了");
    }

    public void method1(){
        System.out.println("生命周期测试类中定义的方法1被执行了");
    }

    public void method2(){
        System.out.println("生命周期测试类中定义的方法2被执行了");
    }
}
