package com.bezkoder.spring.r2dbc.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.r2dbc.h2.model.CustomerOrder;
import com.bezkoder.spring.r2dbc.h2.repository.CustomerOrderRepository;


@Service
public class CustomerOrderService {

  @Autowired
  CustomerOrderRepository customerOrderRepository;

  public List<CustomerOrder> findAll() {
    return customerOrderRepository.findAll();
  }
  //flux is for multiple items



  public CustomerOrder findById(int id) {
    Optional<CustomerOrder> managed = customerOrderRepository.findById(id);
    if(managed.isPresent()){
      return managed.get();
    }else{
      return null;
    }
  }
  //mono is for a single item

  public CustomerOrder save(CustomerOrder customerOrder) {
    return customerOrderRepository.save(customerOrder);
  }

  public CustomerOrder update(int id, CustomerOrder customerOrder) {
   Optional<CustomerOrder> managed = customerOrderRepository.findById(id);
   CustomerOrder toUpdate = null;
   if(managed.isPresent()){
     toUpdate = managed.get();
     toUpdate.setCustomerOrderDate(customerOrder.getCustomerOrderDate());
     toUpdate.setCustomerOrderPayStatus(customerOrder.getCustomerOrderPayStatus());
     toUpdate.setCustomerOrderSubtotal(customerOrder.getCustomerOrderSubtotal());
     toUpdate.setCustomerOrderTax(customerOrder.getCustomerOrderTax());
     toUpdate.setCustomerOrderTotal(customerOrder.getCustomerOrderTotal());

   }
   customerOrderRepository.saveAndFlush(toUpdate);
   return toUpdate;


  }

  public void deleteById(int id) {
    customerOrderRepository.deleteById(id);
  }

  public void deleteAll() {
   customerOrderRepository.deleteAll();
  }

  


}
