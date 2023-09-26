/*
no longer needed after this dependancy

<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>

 */

package com.sakr.employeerestcrudapisv1.service.impl;

import com.sakr.employeerestcrudapisv1.entity.Department;
import com.sakr.employeerestcrudapisv1.exceptions.custom_exceptions.ResourceNotFoundException;
import com.sakr.employeerestcrudapisv1.repository.DepartmentRepository;
import com.sakr.employeerestcrudapisv1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findById(int theId) {
        Optional<Department> result = departmentRepository.findById(theId);

        if (result.isEmpty())
            throw new ResourceNotFoundException("Did not find Department id - " + theId);

        return result.get();
    }

    @Override
    public Department create(Department theDepartment) {
        theDepartment.setDepartmentId(0);
        return departmentRepository.save(theDepartment);
    }

    @Override
    public Department update(Department thDepartment) {
        findById(thDepartment.getDepartmentId());
        return departmentRepository.save(thDepartment);
    }


    @Override
    public void deleteById(int theId) {
        findById(theId);
        departmentRepository.deleteById(theId);
    }
}
