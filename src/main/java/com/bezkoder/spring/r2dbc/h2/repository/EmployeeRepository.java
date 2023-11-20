package com.bezkoder.spring.r2dbc.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.r2dbc.h2.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  //(model, model's id)

  //this is the interface that connect to the tutorial service???


}