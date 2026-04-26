package com.sarni.restful.crud.config;


import com.sarni.restful.crud.interceptor.MyHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MySpringMVCConfig implements WebMvcConfigurer {

    @Autowired
    MyHandlerInterceptor myHandlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor).addPathPatterns("/**");
    }
}
