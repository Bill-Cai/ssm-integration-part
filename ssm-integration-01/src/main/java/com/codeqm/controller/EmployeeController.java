package com.codeqm.controller;

import com.codeqm.pojo.Employee;
import com.codeqm.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @since: 2025/6/9 13:17
 * @author: qm
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public List<Employee> list() {
        log.info("Fetching employee list");
        List<Employee> employees = employeeService.queryList();
        log.info("Employee list fetched successfully, size: {}", employees.size());
        return employees;
    }
}
