/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.springboot.service;

import com.luv2code.springboot.dao.*;
import com.luv2code.springboot.entity.Employee;
import java.util.List;

/**
 *
 * @author Shubham
 */
public interface EmployeeService {
    
    public List<Employee> findAll();
    
    public Employee findById(int theId);
    
    public void save(Employee employee);
    
    public void deleteById(int theId);
    
}
