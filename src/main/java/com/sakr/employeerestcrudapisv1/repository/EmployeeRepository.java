package com.sakr.employeerestcrudapisv1.repository;


import com.sakr.employeerestcrudapisv1.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(path = "employees")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    Optional<Employee> findByEmail(String email);

}
