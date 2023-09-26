package com.sakr.employeerestcrudapisv1.service;

import com.sakr.employeerestcrudapisv1.entity.Department;
import com.sakr.employeerestcrudapisv1.entity.Employee;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findById(int theId);

    Department create(Department theDepartment);

    Department update(Department thDepartment);

    void deleteById(int theId);
}
