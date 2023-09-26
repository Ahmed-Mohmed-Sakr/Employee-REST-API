package com.sakr.employeerestcrudapisv1.repository;

import com.sakr.employeerestcrudapisv1.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
}
