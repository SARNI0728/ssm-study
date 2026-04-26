package com.sarni.restful.crud.controller;

import com.sarni.restful.crud.exception.BizException;
import com.sarni.restful.crud.exception.BizExceptionEnum;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    /**
     * 若是不添加任何异常处理逻辑且在运行时抛出异常，则网页会返回Spring自带的异常页面：
     * {
     *     "timestamp": "2026-04-26T07:59:24.261Z",
     *     "status": 500,
     *     "error": "Internal Server Error",
     *     "path": "/exception"
     * }
     * 所以可以自己添加try catch逻辑对异常进行处理。
     * 但是这种方式并不推荐，因为这种方式有些繁杂。
     */
    @GetMapping("/exception")
    public String exception() {
        int i = 10 / 0;
        return "success";
    }

    /**
     * 介绍注解异常处理方式：@ExceptionHandler
     * 当运行时若是抛出预设好的异常，则会被@ExceptionHandler注解的方法处理。
     */
    /*@ExceptionHandler(value = {ArithmeticException.class})
    // 在value中指定要处理的异常类型
    public String exceptionHandler(Exception e) {
        return "error";
    }*/
}
