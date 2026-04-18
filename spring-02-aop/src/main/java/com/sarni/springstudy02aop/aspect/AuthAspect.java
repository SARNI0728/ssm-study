package com.sarni.springstudy02aop.aspect;


import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1) // Order中的数字越小，越先执行
public class AuthAspect {
    @Pointcut("execution(* com.sarni.springstudy02aop.controller.UserController.*(..))")
    public void pointCut(){}

    // 在使用切面类时，目标对象会被包装成一个代理对象。
    // 因此在有多个切面类时，后加入的那个切面类会将前面的代理对象看作是目标对象 也就是套娃
    // 使用注解@Order 来指定切面类的包裹顺序。

    @Before("pointCut()")
    public void auth(){
        System.out.println("【权限】权限校验");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("【权限】权限校验结束了");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("【权限】权限校验异常了");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("【权限】权限校验返回了结果");
    }
}
