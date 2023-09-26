package com.sakr.employeerestcrudapisv1.rest;

import com.sakr.employeerestcrudapisv1.entity.Department;
import com.sakr.employeerestcrudapisv1.mapper.DepartmentMapper;
import com.sakr.employeerestcrudapisv1.model.DepartmentModel;
import com.sakr.employeerestcrudapisv1.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {

    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper;


    @Autowired
    public DepartmentRestController(DepartmentService departmentService, DepartmentMapper departmentMapper) {
        this.departmentService = departmentService;
        this.departmentMapper = departmentMapper;
    }


    @GetMapping("/departments")
    public List<Department> findAll() {
        return departmentService.findAll();
    }

    @GetMapping("/departments/{departmentId}")
    public Department getDepartmentById(@PathVariable int departmentId) {
        return departmentService.findById(departmentId);
    }


    @PostMapping("/departments")
    public Department addDepartment(@RequestBody DepartmentModel thDepartment) {
        return departmentService.create(departmentMapper.toEntity(thDepartment));
    }

    @PutMapping("/departments")
    public Department updateDepartment(@RequestBody DepartmentModel thDepartment) {
        return departmentService.update(departmentMapper.toEntity(thDepartment));
    }

    @DeleteMapping("/departments/{departmentId}")
    public String deleteDepartment(@PathVariable int departmentId) {
        departmentService.deleteById(departmentId);

        return "Deleted employee id - " + departmentId;
    }
}
