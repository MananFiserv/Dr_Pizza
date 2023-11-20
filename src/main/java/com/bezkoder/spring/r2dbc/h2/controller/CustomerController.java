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
import com.bezkoder.spring.r2dbc.h2.service.CustomerService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/DoctorPizza")
public class CustomerController {
  @Autowired
  CustomerService customerService;
  
  @GetMapping("/customers")
  @ResponseStatus(HttpStatus.OK)
  public List<Customer> getAllCustomers() {
   
      return customerService.findAll();
  
  }

  @GetMapping("/customers/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Customer getCustomerById(@PathVariable("id") int id) {
    return customerService.findById(id);
  }

  @PostMapping("/customers")
  @ResponseStatus(HttpStatus.CREATED)
  public Customer createCustomer(@RequestBody Customer customer) {
    return customerService.save(customer);
  }

  @PutMapping("/customers/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Customer updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
    return customerService.update(id, customer);
  }

  @DeleteMapping("/customers/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomer(@PathVariable("id") int id) {
    customerService.deleteById(id);
  }

  @DeleteMapping("/customers")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAllCustomers() {
     customerService.deleteAll();
  }

  /*@GetMapping("/tutorials/published")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> findByPublished() {
    return tutorialService.findByPublished(true);
  }
   */
}
