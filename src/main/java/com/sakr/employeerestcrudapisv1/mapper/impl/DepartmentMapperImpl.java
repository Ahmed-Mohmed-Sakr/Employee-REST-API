package com.sakr.employeerestcrudapisv1.mapper.impl;

import com.sakr.employeerestcrudapisv1.entity.Department;
import com.sakr.employeerestcrudapisv1.entity.Employee;
import com.sakr.employeerestcrudapisv1.mapper.DepartmentMapper;
import com.sakr.employeerestcrudapisv1.model.DepartmentModel;
import com.sakr.employeerestcrudapisv1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentMapperImpl implements DepartmentMapper {

    DepartmentService departmentService;

    @Autowired
    public DepartmentMapperImpl(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }



    @Override
    public Department toEntity(DepartmentModel departmentModel) {

        Department theDepartment;
        List<Employee> employees = null;

        try {
            theDepartment = departmentService.findById(departmentModel.getDepartmentId());
            employees = theDepartment.getEmployees();
        }catch (Exception ex){}

        return Department.builder()
                .departmentId(departmentModel.getDepartmentId())
                .name(departmentModel.getName())
                .employees(employees)
                .build();
    }
}
