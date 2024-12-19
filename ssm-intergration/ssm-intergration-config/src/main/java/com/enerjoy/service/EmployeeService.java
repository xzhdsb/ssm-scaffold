package com.enerjoy.service;

import com.enerjoy.entity.Employee;

import java.util.List;

/**
 * @author xuzihao
 * @date 2024/12/18 00:42
 * @description:
 */
public interface EmployeeService {

    List<Employee> findAllEmp();
}
