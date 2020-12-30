/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.luv2code.springboot.dao;

import com.luv2code.springboot.entity.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Shubham
 */

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

    @Autowired
    private EntityManager entityManager;
    
    @Override
    public List<Employee> findAll() {
    
        TypedQuery<Employee> query=entityManager.createQuery("from Employee",Employee.class);
        
        List<Employee> list=query.getResultList();
        
        return list;
        
    }

    @Override
    public Employee findById(int theId) {
        
        Employee employee=entityManager.find(Employee.class,theId);
        
        return employee;
    }

    @Override
    public void save(Employee employee) {
        
        entityManager.merge(employee);
    }

    @Override
    public void deleteById(int theId) {
        
        Query theQuery=entityManager.createQuery("delete from Employee where id=:employeeId");
        
        theQuery.setParameter("employeeId",theId);
        
        theQuery.executeUpdate();
    }
    
    
    
}
