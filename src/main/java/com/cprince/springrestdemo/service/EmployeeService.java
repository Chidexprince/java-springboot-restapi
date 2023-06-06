package com.cprince.springrestdemo.service;

import com.cprince.springrestdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int employeeId);
    Employee save(Employee employee);
    void delete(int employeeId);

}
