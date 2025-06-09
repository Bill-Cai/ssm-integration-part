package com.codeqm.mapper;

import com.codeqm.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @since: 2025/6/9 13:12
 * @author: qm
 * @description:
 */
@Mapper
public interface EmployeeMapper {
    List<Employee> queryList();
}
