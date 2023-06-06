package com.cprince.springrestdemo.rest;

import com.cprince.springrestdemo.entity.Employee;
import com.cprince.springrestdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee employee = employeeService.findById(employeeId);

        if(employee == null) {
            throw new RuntimeException("Employee with id - " + employeeId + " not found");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employee.setId(0);

        return employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);

        if(employee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }

        employeeService.delete(employeeId);

    }
}
