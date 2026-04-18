package com.sarni.spring01ioc.config;

import com.sarni.spring01ioc.pojo.Cat;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatConfig {
    @Bean
    public Cat cat() {
        return new Cat();
    }
}
