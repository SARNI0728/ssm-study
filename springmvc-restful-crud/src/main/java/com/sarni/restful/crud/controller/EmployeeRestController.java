package com.sarni.restful.crud.controller;

import com.sarni.restful.crud.common.R;
import com.sarni.restful.crud.pojo.Employee;
import com.sarni.restful.crud.service.EmployeeService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRestController {
    @Autowired
    EmployeeService employeeService;

    // @RequestMapping(value = "/employee/{id}",method = RequestMethod.GET)
    // 可以使用@GetMapping对上面的语句进行简化
    @GetMapping("/employee/{id}")
    R get(@PathVariable Long id){
        return R.ok(employeeService.getEmployeeById(id));
    }

    @PostMapping("/employee")
    R add(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return R.ok();
    }

    @DeleteMapping("/employee/{id}")
    R delete(@PathVariable Long id){
        employeeService.removeEmployeeById(id);
        return R.ok();
    }

    @PutMapping("/employee")
    R update(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return R.ok();
    }

    @GetMapping("/employees")
    R getAll(){
        return R.ok(employeeService.getAllEmployees());
    }


}
