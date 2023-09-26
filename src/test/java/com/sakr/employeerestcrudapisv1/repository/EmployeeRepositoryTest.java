package com.sakr.employeerestcrudapisv1.repository;

import com.sakr.employeerestcrudapisv1.entity.Department;
import com.sakr.employeerestcrudapisv1.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class EmployeeRepositoryTest {


    private  EmployeeRepository employeeRepository;
    private  DepartmentRepository departmentRepository;
    Employee employee1;
    Employee employee2;

    Department department;

    @Autowired
    public EmployeeRepositoryTest(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @BeforeEach
    public void init() {
        department = Department.builder()
                .departmentId(0)
                .name("DEV")
                .employees(null)
                .build();

        departmentRepository.save(department);

         employee1 = Employee.builder()
                .email("ahmedsakr07407@gmail.com")
                .firstName("Ahmed")
                .lastName("sakr")
                 .department(department)
                 .build();

         employee2 = Employee.builder()
                .email("alisakr07407@gmail.com")
                .firstName("ali")
                .lastName("sakr")
                 .department(department)
                 .build();
    }


    @Test
    public void EmployeeRepository_Save_ReturnSavedEmployee() {

        Employee dpEmployee = employeeRepository.save(employee1);

        assertThat(dpEmployee).isNotNull();
        assertThat(dpEmployee.getEmployeeId()).isNotEqualTo(0);
    }

    @Test
    public void EmployeeRepository_FindAll_ReturnAllSavedEmployee() {
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);
        List<Employee> savedEmployees = employeeRepository.findAll();

        assertThat(savedEmployees).isNotNull();
        assertThat(savedEmployees.size()).isEqualTo(2);
    }

    @Test
    public void EmployeeRepository_FindByID_ReturnSavedEmployee() {
        employeeRepository.save(employee1);
        Employee dpEmployee = employeeRepository.findById(employee1.getEmployeeId()).get();

        assertThat(dpEmployee).isNotNull();
        assertThat(dpEmployee.getEmployeeId()).isNotEqualTo(0);
    }

    @Test
    public void EmployeeRepository_FindByEmail_ReturnSavedEmployee() {

        employeeRepository.save(employee1);
        Employee dpEmployee = employeeRepository.findByEmail(employee1.getEmail()).get();

        assertThat(dpEmployee).isNotNull();
        assertThat(dpEmployee.getEmployeeId()).isNotEqualTo(0);
    }

    @Test
    public void EmployeeRepository_update_ReturnUpdatedEmployeeEmployee() {

        Employee savedEmployee = employeeRepository.save(employee1);

        savedEmployee.setFirstName("Ali");
        savedEmployee.setEmail("alisakr07407@gmail.com");

        Employee updatedEmployee = employeeRepository.save(savedEmployee);

        assertThat(updatedEmployee).isNotNull();
        assertThat(updatedEmployee.getEmail()).isEqualTo("alisakr07407@gmail.com");
        assertThat(updatedEmployee.getEmployeeId()).isEqualTo(savedEmployee.getEmployeeId());
    }

    @Test
    public void EmployeeRepository_DeleteByID_ReturnEmptyEmployeesList() {

        employeeRepository.save(employee1);

        employeeRepository.deleteById(employee1.getEmployeeId());
        Optional<Employee> dpEmployee = employeeRepository.findById(employee1.getEmployeeId());

        assertThat(dpEmployee).isEmpty();
    }


}

