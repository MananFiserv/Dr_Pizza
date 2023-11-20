package com.bezkoder.spring.r2dbc.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.r2dbc.h2.model.Customer;
import com.bezkoder.spring.r2dbc.h2.repository.CustomerRepository;


@Service
public class CustomerService{

  @Autowired
  CustomerRepository customerRepository;

  public List<Customer> findAll() {
    return customerRepository.findAll();
  }
  //flux is for multiple items



  public Customer findById(int id) {
    Optional<Customer> managed = customerRepository.findById(id);
    if(managed.isPresent()){
      return managed.get();
    }else{
      return null;
    }
  }
  //mono is for a single item

  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  public Customer update(int id, Customer customer) {
   Optional<Customer> managed = customerRepository.findById(id);
   Customer toUpdate = null;
   if(managed.isPresent()){
     toUpdate = managed.get();
     toUpdate.setAddress(customer.getAddress());
     toUpdate.setCity(customer.getCity());
     toUpdate.setFirstName(customer.getFirstName());
     toUpdate.setLastName(customer.getLastName());
     toUpdate.setPhoneNumberId(customer.getPhoneNumberId());

   }
   customerRepository.saveAndFlush(toUpdate);
   return toUpdate;


  }

  public void deleteById(int id) {
    customerRepository.deleteById(id);
  }

  public void deleteAll() {
   customerRepository.deleteAll();
  }


}
