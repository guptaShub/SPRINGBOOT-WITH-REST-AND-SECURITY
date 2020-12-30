/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.springboot.rest;


import com.luv2code.springboot.entity.Employee;
import com.luv2code.springboot.service.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Shubham
 */
@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employee")
    public List<Employee> getEmployeeList(){
        return employeeService.findAll();
    }
    
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }
    
    @PostMapping("/employee")
    public String saveEmployee(@RequestBody Employee employee)
    {
        employee.setId(0);
        employeeService.save(employee);
        return "Employee Saved";
    }
    
    @PutMapping("/employee/{employeeId}")
    public String updateEmployee(@RequestBody Employee employee,@PathVariable int employeeId)
    {
        employee.setId(employeeId);
        employeeService.save(employee);
        return "Employee Updated";
    }
    
    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId)
    {
        employeeService.deleteById(employeeId);
        return "Employee Deleted";
    }
    
}
