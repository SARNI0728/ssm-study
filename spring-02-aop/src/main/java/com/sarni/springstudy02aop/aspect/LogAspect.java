package com.sarni.springstudy02aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(100)
public class LogAspect {
    /**
     * 切面类： 切面类的作用是定义一些通知方法。
     * 通知方法指的是在方法的某些执行的阶段前后做一些事。
     *
     * 在spring中一个切面类中有以下注解：
     * @Before： 在方法执行之前运行
     * @AfterReturning： 在方法返回结果之后运行
     * @AfterThrowing: 在方法抛出异常以后运行
     * @After： 在方法执行以后运行。
     */

    /**
     * 定义了一个切入点， 切入点指的是哪些方法需要被增强。
     * 写在这里在其他通知方法中直接调用即可
     */
    @Pointcut("execution(* com.sarni.springstudy02aop.controller.UserController.*(..))")
    public void pointCut(){}

    //在上面的提到的注解中 需要在参数中指定哪些方法在执行期间需要执行注解下面的方法。
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint){
        // 现在还有一个问题就是，在打日志的时候，我们需要知道当前执行的是哪个方法。
        // 实际上Spring 为我们提供了一个对象，这个对象就是JoinPoint 对象。
        // JoinPoint 对象中包含了当前执行的方法的信息。
        Signature signature = joinPoint.getSignature();
        // Signature太大 所以需要使用MethodSignature 来获取方法的信息
        MethodSignature methodSignature = (MethodSignature) signature;
        System.out.println("【日志】方法名：" + methodSignature.getName() + "就要执行了");
    }

    // 在方法执行之后，我们需要知道方法的返回值。
    // Spring还为我们提供了一个对象，这个对象就是Returning 对象。
    // Returning 对象中包含了方法的返回值。
    // 在注解中声明一个returning 属性， 这个属性指的是方法的返回值。
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logEnd(JoinPoint joinPoint, Object result){
        // 在注解中声明好return以后 在函数的参数中使用同名的类型接收
        System.out.println("【日志】方法返回结果：" + result);
    }

    @AfterThrowing("pointCut()")
    public void logException(){
        System.out.println("【日志】方法执行异常了");
    }

    @After("pointCut()")
    public void logAfter(){
        System.out.println("【日志】方法执行结束了");
    }


    // 增强器链： 切面中的所有通知方法其实就是增强器。他们被组织成一个链路放到集合中。
    // 目标方法真正执行前后，会去增强器链中执行哪些需要提前执行的方法。
    //AOP 的底层原理
    //1、Spring会为每个被切面切入的组件创建代理对象(Spring CGLIB 创建的代理对象，无视接口)。
    //2、代理对象中保存了切面类里面所有通知方法构成的增强器链。
    //3、目标方法执行时，会先去执行增强器链中拿到需要提前执行的通知方法去执行
}
