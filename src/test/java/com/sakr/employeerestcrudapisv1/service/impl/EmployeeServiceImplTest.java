package com.sakr.employeerestcrudapisv1.service.impl;



import com.sakr.employeerestcrudapisv1.entity.Employee;
import com.sakr.employeerestcrudapisv1.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;


    @Test
    public void EmployeeService_FindAllEmployee_ReturnListOfEmployee(){
        Employee employee = Employee.builder()
                .email("ahmedsakr07407@gmail.com")
                .firstName("Ahmed").employeeId(0)
                .lastName("sakr").build();

        List<Employee> employees = new ArrayList<Employee>();
        employees.add(employee);

        when(employeeRepository.findAll()).thenReturn(employees);

        List<Employee> dpEmployees = employeeService.findAll();

        assertThat(dpEmployees).isNotNull();
        assertThat(dpEmployees.size()).isEqualTo(1);
    }

    @Test
    public void EmployeeService_CreateEmployee_ReturnDbEmployee(){
        Employee employee = Employee.builder()
                .email("ahmedsakr07407@gmail.com")
                .firstName("Ahmed").employeeId(0)
                .lastName("sakr").build();

        when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

        Employee dpEmployee = employeeService.create(employee);

        assertThat(dpEmployee).isNotNull();
        verify(employeeRepository, times(1)).save(any(Employee.class));
    }

}
