package com.bezkoder.spring.r2dbc.h2.controller;

import java.sql.Date;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.List;
//import java.util.stream.Collector;
import java.util.stream.Collectors;

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
import com.bezkoder.spring.r2dbc.h2.model.CustomerOrder;
import com.bezkoder.spring.r2dbc.h2.model.Employee;
import com.bezkoder.spring.r2dbc.h2.service.CustomerOrderService;
import com.bezkoder.spring.r2dbc.h2.service.CustomerService;
import com.bezkoder.spring.r2dbc.h2.service.EmployeeService;

//import net.snowflake.client.jdbc.internal.apache.arrow.flatbuf.Timestamp;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/DoctorPizza")
public class CustomerOrderController {
  @Autowired
  CustomerOrderService customerOrderService;
  EmployeeService employeeService;
  CustomerService customerService;
  
  
  @GetMapping("/customer_order")
  @ResponseStatus(HttpStatus.OK)
  public List<CustomerOrder> getAllCustomerOrders() {
      return customerOrderService.findAll();
    
  }

  @GetMapping("/customer_order/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CustomerOrder getCustomerOrderById(@PathVariable("id") int id) {
    return customerOrderService.findById(id);
  }

  @GetMapping("/customer_order_by_employee_by_week/{employeeId}/{week}")
  @ResponseStatus(HttpStatus.OK)
  public List<CustomerOrder> getCustomerOrdersByEmployeeByWeek(@PathVariable("emlployeeId") int employeeId, @PathVariable("week") String week) {
 
    //returns all customer orders in our database
    List<CustomerOrder> customerOrders = customerOrderService.findAll();
    //returns all cutomer order associated with specific employee Id
    customerOrders = customerOrders.stream().filter(customerOrder -> customerOrder.getCustomerEmployeeId() == employeeId).collect(Collectors.toList());
    customerOrders = customerOrders.stream().filter(customerOrder -> customerOrder.getCustomerOrderDate().toString() == week).collect(Collectors.toList());
    return customerOrders;
  }

    @GetMapping("/customer_order_by_zipcode_by_week/{zipcode}/{week}")
  @ResponseStatus(HttpStatus.OK)
  public List<CustomerOrder> getCustomerOrdersByZipCodeByWeek(@PathVariable("zipCode") int zipCode, @PathVariable("week") String week) {
 
    
    List<Customer> customers = customerService.findAll();
     List<CustomerOrder> customerOrders = customerOrderService.findAll();
     List<CustomerOrder> finalOrders = new ArrayList<>();
    
    ///all the customers that have matching zip code 
     customers = customers.stream().filter(customer-> customer.getZipCode() == zipCode).collect(Collectors.toList());

  
    //all the customer orders with matching week (Date which week is in)
    //Don't know how to break down (Timestamp) type to get exact week
    customerOrders = customerOrders.stream().filter(customerOrder -> customerOrder.getCustomerOrderDate().toString() == week).collect(Collectors.toList());

    //iterate through all the customer orders with matching (Date) week
    //also iterating through all the customers with matching zip code
    //only appending orders that have matching numbers 
    for (CustomerOrder order: customerOrders){
      for(Customer customer: customers){
        if(order.getCustomerPhoneNumber() == customer.getPhoneNumberId()){
        finalOrders.add(order);
        }
      }
    }

   
    return finalOrders;
  }

 

  @GetMapping("/customer_order_date/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Date getCustomerOrderTimestamp(@PathVariable("id") int id) {
    CustomerOrder customerOrder = customerOrderService.findById(id);
    return customerOrder.getCustomerOrderDate(); 

  }

   @GetMapping("/customer_order_employee/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Employee getEmployeeByOrderId(@PathVariable("id") int id) {
    int employeeId = customerOrderService.findById(id).getCustomerEmployeeId();
    return employeeService.findById(employeeId); 

  }

  @PostMapping("/customer_order")
  @ResponseStatus(HttpStatus.CREATED)
  public CustomerOrder createCustomerOrder(@RequestBody CustomerOrder customerOrder) {
    return customerOrderService.save(customerOrder);
  }

  @PutMapping("/customer_order/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CustomerOrder updateCustomerOrder(@PathVariable("id") int id, @RequestBody CustomerOrder customerOrder) {
    return customerOrderService.update(id, customerOrder);
  }

  @DeleteMapping("/customer_order/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteCustomerOrder(@PathVariable("id") int id) {
    customerOrderService.deleteById(id);
  }

  @DeleteMapping("/customer_order")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAllCustomerOrders() {
     customerOrderService.deleteAll();
  }

  /*@GetMapping("/tutorials/published")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> findByPublished() {
    return tutorialService.findByPublished(true);
  }
   */
}
