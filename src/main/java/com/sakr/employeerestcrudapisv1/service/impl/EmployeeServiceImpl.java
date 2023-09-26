/*
no longer needed after this dependancy

<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>

 */

package com.sakr.employeerestcrudapisv1.service.impl;

import com.sakr.employeerestcrudapisv1.entity.Employee;
import com.sakr.employeerestcrudapisv1.exceptions.custom_exceptions.ResourceNotFoundException;
import com.sakr.employeerestcrudapisv1.repository.EmployeeRepository;
import com.sakr.employeerestcrudapisv1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        if (result.isEmpty())
            throw new ResourceNotFoundException("Did not find employee id - " + theId);

        return result.get();
    }

    @Override
    public Employee findByEmail(String email) {
        Optional<Employee> result = employeeRepository.findByEmail(email);

        if (result.isEmpty())
            throw new ResourceNotFoundException("Did not find employee with email - " + email);

        return result.get();
    }

    @Override
    public Employee create(Employee theEmployee) {
        // set id to 0 so you always force merge to add new element
        theEmployee.setEmployeeId(0);
        return employeeRepository.save(theEmployee);
    }

    @Override
    public Employee update(Employee theEmployee) {
        findById(theEmployee.getEmployeeId());
        return employeeRepository.save(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        findById(theId);
        employeeRepository.deleteById(theId);
    }
}
