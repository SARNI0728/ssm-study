package com.sarni.restful.crud.advice;

import com.sarni.restful.crud.common.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// 全局异常处理器
//@ResponseBody // 表示这个组件返回的数据直接写给浏览器，不经过视图解析器
//@ControllerAdvice //告诉SpringMVC，这个组件是专门负责进行全局异常处理的
@RestControllerAdvice // 等价于上面两个注解的结合
public class GlobalExceptionHandler {
    /**
     * 在controller层中对应的组件写的异常处理方法只能负责对应组件抛出的异常。
     * 解决方式是可以写一个这样的全局的异常处理类，然后在配置类中配置这个全局的异常处理类。
     */
    @ExceptionHandler(Throwable.class)
    public R exceptionHandler(Exception e) {
        return R.error(e.getMessage());
    }
}
