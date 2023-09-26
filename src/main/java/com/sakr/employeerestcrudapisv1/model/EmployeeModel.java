package com.sakr.employeerestcrudapisv1.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private int departmentId;
}
