package com.codeqm.service.impl;

import com.codeqm.mapper.EmployeeMapper;
import com.codeqm.pojo.Employee;
import com.codeqm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @since: 2025/6/9 13:15
 * @author: qm
 * @description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> queryList() {
        return employeeMapper.queryList();
    }
}
