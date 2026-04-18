package com.sarni.spring01ioc.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

// 若是把所有的配置信息全都放到application.properties中则显得有点拥挤
// 所以可以另外创建配置文件信息，比如cat.properties，然后使用下面的这个注解给这个类专门制定一个配置文件
@PropertySource("classpath:cat.properties")
@Data
public class Cat {
    // Value注解的用法：
    // Value注解可以直接在对象的属性上使用，有三种用法：
    // 1. 直接在属性上使用， 如： @Value("Nancy")，表示默认值为Nancy
    @Value("Nancy")
    private String name;

    // 2.@Value("${cat.age}")代表从配置文件中获取cat.age的值然后赋值给下面的属性
    // 若是配置文件中没有cat.age的值，则会报错
    // 另可以使用@Value("${cat.age:1}") 来指定默认值， 若是配置文件中没有cat.age的值，则会使用默认值1
    @Value("${cat.age:1}")
    private Integer age;

    //3. @Value("#{SpEL}") 代表使用SpEL表达式来赋值
    @Value("#{T(java.util.UUID).randomUUID().toString()}")
    private String id;
}
