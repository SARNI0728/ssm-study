package com.sarni.restful.crud.service.impl;

import com.sarni.restful.crud.dao.EmployeeDao;
import com.sarni.restful.crud.pojo.Employee;
import com.sarni.restful.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.insertEmployee(employee);
    }

    @Override
    public void removeEmployeeById(Long id) {
        employeeDao.deleteEmployeeById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Employee empById = getEmployeeById(employee.getId());

        if(employee.getId()!=null){
            empById.setId(employee.getId());
        }

        if(employee.getAge()!=null){
            empById.setAge(employee.getAge());
        }

        if(employee.getSalary()!=null){
            empById.setSalary(employee.getSalary());
        }

        if(StringUtils.hasText(employee.getName())){
            empById.setName(employee.getName());
        }

        if(StringUtils.hasText(employee.getEmail())){
            empById.setEmail(employee.getEmail());
        }

        if(StringUtils.hasText(employee.getGender())){
            empById.setGender(employee.getGender());
        }

        if(StringUtils.hasText(employee.getAddress())){
            empById.setAddress(employee.getAddress());
        }

        employeeDao.updateEmployee(empById);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeDao.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
