package com.cprince.springrestdemo.service;

import com.cprince.springrestdemo.dao.EmployeeDao;
import com.cprince.springrestdemo.entity.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;


    public EmployeeServiceImpl(EmployeeDao theEmployeeDao) {
        employeeDao = theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDao.save(employee);
    }
    @Transactional
    @Override
    public void delete(int employeeId) {
        employeeDao.delete(employeeId);
    }
}
