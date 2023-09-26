package com.sakr.employeerestcrudapisv1.mapper.impl;

import com.sakr.employeerestcrudapisv1.entity.Department;
import com.sakr.employeerestcrudapisv1.entity.Employee;
import com.sakr.employeerestcrudapisv1.mapper.EmployeeMapper;
import com.sakr.employeerestcrudapisv1.model.EmployeeModel;
import com.sakr.employeerestcrudapisv1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    DepartmentService departmentService;

    @Autowired
    public EmployeeMapperImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @Override
    public Employee toEntity(EmployeeModel employeeModel) {
        Department department = departmentService.findById(employeeModel.getDepartmentId());

        return Employee.builder()
                .employeeId(employeeModel.getEmployeeId())
                .firstName(employeeModel.getFirstName())
                .lastName(employeeModel.getLastName())
                .email(employeeModel.getEmail())
                .department(department)
                .build();
    }
}
