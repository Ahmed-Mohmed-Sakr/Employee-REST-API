/*
no longer needed after this dependancy

<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>

 */

package com.sakr.employeerestcrudapisv1.rest;

import com.sakr.employeerestcrudapisv1.entity.Employee;
import com.sakr.employeerestcrudapisv1.mapper.EmployeeMapper;
import com.sakr.employeerestcrudapisv1.model.EmployeeModel;
import com.sakr.employeerestcrudapisv1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private final EmployeeService employeeService;
    private  final EmployeeMapper employeeMapper;


    @Autowired
    public EmployeeRestController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        return employeeService.findById(employeeId);
    }

    @GetMapping("/employees/{email}/by-email")
    public Employee getEmployeeByEmail(@PathVariable String email) {
        return employeeService.findByEmail(email);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody EmployeeModel thEmployee) {
        return employeeService.create(employeeMapper.toEntity(thEmployee));
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody EmployeeModel thEmployee) {
        return employeeService.update(employeeMapper.toEntity(thEmployee));
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }


}
