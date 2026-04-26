package com.sarni.restful.crud;

import com.sarni.restful.crud.controller.EmployeeRestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmvcPracticeApplication {
    @Autowired
    EmployeeRestController employeeController;

    public static void main(String[] args) {
        SpringApplication.run(SpringmvcPracticeApplication.class, args);


    }

}
