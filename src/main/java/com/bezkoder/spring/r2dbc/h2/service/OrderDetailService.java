package com.bezkoder.spring.r2dbc.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.r2dbc.h2.model.OrderDetail;
import com.bezkoder.spring.r2dbc.h2.repository.OrderDetailRepository;



@Service
public class OrderDetailService {

  @Autowired
  OrderDetailRepository orderDetailRepository;

  public List<OrderDetail> findAll() {
    return orderDetailRepository.findAll();
  }
  //flux is for multiple items



  public OrderDetail findById(int id) {
    Optional<OrderDetail> managed = orderDetailRepository.findById(id);
    if(managed.isPresent()){
      return managed.get();
    }else{
      return null;
    }
  }
  //mono is for a single item

  public OrderDetail save(OrderDetail orderDetail) {
    return orderDetailRepository.save(orderDetail);
  }

  public OrderDetail update(int id, OrderDetail orderDetail) {
   Optional<OrderDetail> managed = orderDetailRepository.findById(id);
   OrderDetail toUpdate = null;
   if(managed.isPresent()){
     toUpdate = managed.get();
     toUpdate.setORderDetailSubtotal(orderDetail.getOrderDetailSubtotal());

   }
   orderDetailRepository.saveAndFlush(toUpdate);
   return toUpdate;


  }

  public void deleteById(int id) {
    orderDetailRepository.deleteById(id);
  }

  public void deleteAll() {
   orderDetailRepository.deleteAll();
  }


}

