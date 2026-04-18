package com.sarni.spring01ioc.config;

import com.sarni.spring01ioc.pojo.BeanLifeCircleTestPojo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanLifeCircleTestConfig {
    @Bean(initMethod = "method1", destroyMethod = "method2")
    public BeanLifeCircleTestPojo beanLifeCircleTestPojo(){
        return new BeanLifeCircleTestPojo();
    }
}
