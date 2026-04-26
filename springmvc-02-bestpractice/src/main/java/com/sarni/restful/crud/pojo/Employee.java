package com.sarni.restful.crud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {
    Long id;
    String name;
    Integer age;
    String email;
    String gender;
    String address;
    BigDecimal Salary;
}
