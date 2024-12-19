package com.enerjoy.service.impl;

import com.enerjoy.entity.Employee;
import com.enerjoy.mapper.EmployeeMapper;
import com.enerjoy.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @author xuzihao
 * @date 2024/12/18 00:44
 * @description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeMapper employeeMapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }

    @Override
    public List<Employee> findAllEmp() {
        System.out.println("执行位置1");
        return employeeMapper.queryAll();
    }
}
