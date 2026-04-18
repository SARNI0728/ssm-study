package com.sarni.spring01ioc.proxy.Dynamic;


import java.lang.reflect.Proxy;

public class DynamicProxy{
    // 获取动态代理对象
    public static Object getDynamicProxy(Object target){
        // 使用Java自带的newProxyInstance方法创建动态代理对象
        return Proxy.newProxyInstance(
                // 参数1: 目标对象的类加载器
                target.getClass().getClassLoader(),
                // 参数2: 目标对象的接口数组
                target.getClass().getInterfaces(),
                // 参数3: InvocationHandler： 这个的作用就是在目标对象执行方法的前后做一些额外操作。
                (proxy, method, args) -> {
                    // InvocationHandler 中也有三个参数：
                    // 参数1: proxy: 指的是代理对象
                    // 参数2: method: 指的是目标对象真正要执行的那个方法
                    // 参数3: args: 指的是目标对象真正要执行的方法的参数
                    System.out.println("开始执行方法： "+ method.getName() + " 参数： " + args);
                    try{
                        Object invoke = method.invoke(target, args);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        System.out.println("执行方法结束： "+ method.getName());
                    }

                    return proxy;
                }
        );
    }
}
