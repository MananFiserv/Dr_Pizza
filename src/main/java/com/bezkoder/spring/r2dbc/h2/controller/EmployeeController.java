package com.bezkoder.spring.r2dbc.h2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.r2dbc.h2.model.Customer;
import com.bezkoder.spring.r2dbc.h2.model.Employee;
import com.bezkoder.spring.r2dbc.h2.service.EmployeeService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/DoctorPizza")
public class EmployeeController {
  @Autowired
  EmployeeService employeeService;
  
  /*@GetMapping("/tutorials")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
    if (title == null)
      return tutorialService.findAll();
    else
      return tutorialService.findByTitleContaining(title);
  }*/
  
  @GetMapping("/employees")
  @ResponseStatus(HttpStatus.OK)
  public List<Employee> getAllTutorials() {
   
      return employeeService.findAll();
  
  }

  @GetMapping("/employee/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Employee getEmployeeById(@PathVariable("id") int id) {
    return employeeService.findById(id);
  }

  @PostMapping("/employee")
  @ResponseStatus(HttpStatus.CREATED)
  public Employee createEmployee(@RequestBody Employee employee) {
    return employeeService.save(employee);
  }

  @PutMapping("/employee/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Employee updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
    return employeeService.update(id, employee);
  }

  @DeleteMapping("/employee/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteEmployee(@PathVariable("id") int id) {
    employeeService.deleteById(id);
  }

  @DeleteMapping("/employee")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAllEmployees() {
    employeeService.deleteAll();
  }



  /*@GetMapping("/tutorials/published")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> findByPublished() {
    return tutorialService.findByPublished(true);
  }
   */
}
