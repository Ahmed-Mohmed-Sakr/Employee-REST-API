package com.sakr.employeerestcrudapisv1.mapper;

import com.sakr.employeerestcrudapisv1.entity.Employee;
import com.sakr.employeerestcrudapisv1.model.EmployeeModel;

public interface EmployeeMapper {

    Employee toEntity(EmployeeModel employeeModel);

}
