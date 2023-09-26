CREATE DATABASE  IF NOT EXISTS `EMPLOYEE_DIRECTORY`;
USE `EMPLOYEE_DIRECTORY`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS employees;
DROP TABLE IF EXISTS departments;

CREATE TABLE departments (
                             department_id INT NOT NULL AUTO_INCREMENT,
                             name VARCHAR(45) DEFAULT NULL,
                             PRIMARY KEY (department_id)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE employees (
                           employee_id int NOT NULL AUTO_INCREMENT,
                           first_name varchar(45) DEFAULT NULL,
                           last_name varchar(45) DEFAULT NULL,
                           email varchar(45) DEFAULT NULL unique ,
                           department_id INT NOT NULL,
                           PRIMARY KEY (employee_id),
                           FOREIGN KEY (department_id) REFERENCES departments (department_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT  INTO `departments`  VALUES
                                (1,'DEV'),
                                (2,'DESIGN'),
                                (3,'HR');

INSERT  INTO `employees`  VALUES
                              (0,'Ahmed','Sakr','ahmed@gmail.com',1),
                              (0,'Ali','Nader','ali@gmail.com',2),
                              (0,'Zainb','Sakr','zainb@gmail.com',1),
                              (0,'Nader','Ali','nader@gmail.com',3),
                              (0,'Mai','Ali','mai@gmail.com',1);

