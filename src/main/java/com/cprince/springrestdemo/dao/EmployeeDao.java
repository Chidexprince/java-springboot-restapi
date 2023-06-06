package com.cprince.springrestdemo.dao;

import com.cprince.springrestdemo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();
    Employee findById(int employeeId);
    Employee save(Employee employee);
    void delete(int employeeId);
}
