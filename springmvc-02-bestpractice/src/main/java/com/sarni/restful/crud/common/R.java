package com.sarni.restful.crud.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 使用R对象来解决后端返回给前端数据不统一的问题
@AllArgsConstructor
@NoArgsConstructor
@Data
// 类名后面的这个T是告诉编译器这是一个模版
public class R<T> {
    private Integer code;
    private String msg;
    private T data;


    // 在public static后面的这个T是告诉编译器后面的内容中会使用到一个T参数，这个参数是一个范型。
    // 在R后面的这个T指的是告诉编译器当这个R方法调用结束以后，会返回一个T类型的R对象。
    public static<T> R<T> ok(T data) {
        return new R<>(200, "success", data);
    }

    public static R ok() {
        return new R(200, "success", null);
    }

    public static R error(String msg) {
        return new R(500, msg, null);
    }
}
