package com.sarni.restful.crud.service;

import com.sarni.restful.crud.pojo.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void removeEmployeeById(Long id);

    void updateEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();
}
