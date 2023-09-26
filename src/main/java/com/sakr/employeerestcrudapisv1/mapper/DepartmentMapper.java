package com.sakr.employeerestcrudapisv1.mapper;

import com.sakr.employeerestcrudapisv1.entity.Department;
import com.sakr.employeerestcrudapisv1.model.DepartmentModel;

public interface DepartmentMapper {

    Department toEntity(DepartmentModel departmentModel);

}
