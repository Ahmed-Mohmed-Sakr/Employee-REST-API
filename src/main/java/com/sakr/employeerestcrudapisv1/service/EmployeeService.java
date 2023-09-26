package com.sakr.employeerestcrudapisv1.service;

import com.sakr.employeerestcrudapisv1.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee findByEmail(String email);

    Employee create(Employee theEmployee);

    Employee update(Employee theEmployee);

    void deleteById(int theId);
}
