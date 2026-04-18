package com.sarni.spring01ioc.processor;

import com.sarni.spring01ioc.pojo.Car;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public @Nullable Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitializationf方法执行了");
        if(bean instanceof Car car){
            car.setId(UUID.randomUUID().toString());
        }
        return bean;
    }
}
