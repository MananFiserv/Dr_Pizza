package com.bezkoder.spring.r2dbc.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.r2dbc.h2.model.Employee;
import com.bezkoder.spring.r2dbc.h2.repository.EmployeeRepository;


@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;

  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }
  //flux is for multiple items



  public Employee findById(int id) {
    Optional<Employee> managed = employeeRepository.findById(id);
    if(managed.isPresent()){
      return managed.get();
    }else{
      return null;
    }
  }
  //mono is for a single item

  public Employee save(Employee employee) {
    return employeeRepository.save(employee);
  }

  public Employee update(int id, Employee employee) {
   Optional<Employee> managed = employeeRepository.findById(id);
   Employee toUpdate = null;
   if(managed.isPresent()){
     toUpdate = managed.get();
     toUpdate.setEmployeeStatus(employee.getEmployeeStatus());
     toUpdate.setFirstName(employee.getFirstName());
     toUpdate.setHireDate(employee.getHireDate());
     toUpdate.setId(employee.getEmployeeId());
     toUpdate.setLastName(employee.getLastName());
    
   }
   employeeRepository.saveAndFlush(toUpdate);
   return toUpdate;


  }

  public void deleteById(int id) {
    employeeRepository.deleteById(id);
  }

  public void deleteAll() {
   employeeRepository.deleteAll();
  }
  /*public void employeeServiceDeleteAll() {
    employeeRepository.deleteAll();
} */


}
