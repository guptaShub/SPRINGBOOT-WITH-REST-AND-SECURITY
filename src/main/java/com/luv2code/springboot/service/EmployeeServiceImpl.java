/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.springboot.service;

import com.luv2code.springboot.dao.EmployeeDao;
import com.luv2code.springboot.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Shubham
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDao employeeDao;
    
    @Override
    @Transactional
    public List<Employee> findAll() {
    
        return employeeDao.findAll();    
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        
        return employeeDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee employee) {

        employeeDao.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        
        employeeDao.deleteById(theId);
    }
    
    
    
}
