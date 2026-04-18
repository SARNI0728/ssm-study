package com.sarni.spring01ioc.config;

import com.sarni.spring01ioc.condition.MaleCondition;
import com.sarni.spring01ioc.pojo.Dog;
import com.sarni.spring01ioc.pojo.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DogConfig {

    @Bean
    public Dog dog() {
        return new Dog();
    }

}
