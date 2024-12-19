package com.enerjoy.controller;

import com.enerjoy.entity.Employee;
import com.enerjoy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author xuzihao
 * @date 2024/12/18 00:39
 * @description:
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> findAll() {
        return employeeService.findAllEmp();
    }
}
