CREATE SCHEMA IF NOT EXISTS EMPLOYEE_DIRECTORY;
USE EMPLOYEE_DIRECTORY;

--
-- Table structure for table `departments`
--

DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
                             department_id INT NOT NULL AUTO_INCREMENT,
                             name VARCHAR(255) DEFAULT NULL,
                             PRIMARY KEY (department_id)
);

--
-- Table structure for table `employees`
--

DROP TABLE IF EXISTS employees;

CREATE TABLE employees (
                           employee_id INT NOT NULL AUTO_INCREMENT,
                           first_name VARCHAR(255) DEFAULT NULL,
                           last_name VARCHAR(255) DEFAULT NULL,
                           email VARCHAR(255) DEFAULT NULL UNIQUE,
                           department_id INT NOT NULL,
                           PRIMARY KEY (employee_id),
                           FOREIGN KEY (department_id) REFERENCES departments (department_id)
);
