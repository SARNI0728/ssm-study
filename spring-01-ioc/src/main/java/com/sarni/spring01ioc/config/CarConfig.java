package com.sarni.spring01ioc.config;

import com.sarni.spring01ioc.pojo.Car;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CarConfig {
    @Bean
    public Car car(){
        return new Car();
    }
}
