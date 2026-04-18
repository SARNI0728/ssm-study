package com.sarni.springstudy02aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AroundAspect {

    @Pointcut("execution(* com.sarni.springstudy02aop.controller.UserController.*(..))")
    public void pointCut(){}
    // 环绕切面类： 环绕切面是对于那4个通知方法的 4合1方法。
    // 或者说也可以叫做一个增强方法，它可以像动态代理那样修改方法的参数，返回值等等···

    /**
     * 环绕切面的固定写法：
     * @Around("pointCut()")
     * public Object around(ProceedingJoinPoint pjp) throws Throwable{
     *      // 接收参数
     *      Object[] args = pjp.getArgs();
     *
     *      // 方法执行
     *      Object result = pjp.proceed(args);
     *
     *      // 返回结果
     *      return result;
     * }
     */

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object[] args = pjp.getArgs(); // 获取方法的参数
        System.out.println("【环绕】方法执行之前,参数是：" + Arrays.toString(args));
        Object result = null; // 这里的result 就是方法的返回值 先设置返回值为null
        try {
            result = pjp.proceed(args);
            System.out.println("【环绕】方法执行成功，返回结果：" + result);
        }catch (Exception e){
            System.out.println("【环绕】方法执行异常了");
            throw e;
            // 重点： 在环绕内的方法如果异常了 若仅仅是抓住了异常 没有像这样进行抛出
            // 外层的代理对象并不会知道内部的方法出现了异常
        }
        System.out.println("【环绕】方法执行结束");
        return result;
    }
}
