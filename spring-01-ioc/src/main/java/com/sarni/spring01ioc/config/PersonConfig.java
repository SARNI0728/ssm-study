package com.sarni.spring01ioc.config;

import com.sarni.spring01ioc.condition.FemaleCondition;
import com.sarni.spring01ioc.condition.MaleCondition;
import com.sarni.spring01ioc.pojo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class PersonConfig {
    @Conditional(MaleCondition.class)
    @Bean
    public Person sarni() {
        return new Person("sarni", 18);
    }

    @Conditional(FemaleCondition.class)
    @Bean
    public Person gaojinxuan() {
        return new Person("gaojinxuan", 18);
    }
}
