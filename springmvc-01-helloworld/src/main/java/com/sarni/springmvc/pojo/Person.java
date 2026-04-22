package com.sarni.springmvc.pojo;

import lombok.Data;

@Data
public class Person {
    private String username;
    private String password;
    private String cellphone;
    private Boolean agreement;

    private Address address;

    private String[] hobby;
    private String grade;
    private String sex;
}
