package com.sarni.restful.crud.dao;

import com.sarni.restful.crud.pojo.Employee;

import java.util.List;

// 实现对Employee类的增删改查
public interface EmployeeDao {
    // 查
    Employee getEmployeeById(Long id);

    // 增
    void insertEmployee(Employee employee);

    // 改
    void updateEmployee(Employee employee);

    // 删
    void deleteEmployeeById(Long id);

    List<Employee> getAllEmployees();
}
