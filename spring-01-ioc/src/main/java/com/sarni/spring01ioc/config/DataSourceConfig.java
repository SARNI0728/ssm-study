package com.sarni.spring01ioc.config;

import com.sarni.spring01ioc.datasource.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DataSourceConfig {

    // Profile的作用举例
    // 现在有个要求，在dev环境下，数据库的用户名和密码是dev，
    // 在test环境下，数据库的用户名和密码是test，
    // 在prod环境下，数据库的用户名和密码是prod
    // 也就是实际开发中，我们得按照不同的需要采用不同的环境。
    // 若是使用以前的方法，在切换环境时，在@Bean前添加上@Primary注解 这样实际上是在侵入代码，不符合开闭原则
    // 现在使用Profile注解，在切换环境时，只需要在配置文件中修改对应的环境即可完成环境的切换。
    //default是默认环境，如果没有指定环境，则使用default环境
    // 在配置文件的application.properties字段中指定需要切换的开发环境
    @Profile({"dev", "default"})
    @Bean
    public MyDataSource dev() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/dev");
        myDataSource.setUsername("dev");
        myDataSource.setPassword("admin123");
        return myDataSource;
    }

    @Profile("test")
    @Bean
    public MyDataSource test() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/test");
        myDataSource.setUsername("test");
        myDataSource.setPassword("admin123");
        return myDataSource;
    }

    @Profile("prod")
    @Bean
    public MyDataSource prod() {
        MyDataSource myDataSource = new MyDataSource();
        myDataSource.setUrl("jdbc:mysql://localhost:3306/prod");
        myDataSource.setUsername("prod");
        myDataSource.setPassword("admin123");
        return myDataSource;
    }
}
