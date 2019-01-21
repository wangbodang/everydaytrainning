package com.wangbodang.demo.mapper;

import com.wangbodang.demo.entity.Employee;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    Integer findMaxId();

    int batchInsertEmp(List<Employee> empList);

    int batchUpdateEmp(List<Employee> empList);
}