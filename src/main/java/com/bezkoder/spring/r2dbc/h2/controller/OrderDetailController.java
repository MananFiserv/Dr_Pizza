package com.bezkoder.spring.r2dbc.h2.controller;

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

import com.bezkoder.spring.r2dbc.h2.model.OrderDetail;
import com.bezkoder.spring.r2dbc.h2.service.OrderDetailService;


@CrossOrigin(origins = "http://localhost:8005")
@RestController
@RequestMapping("/DoctorPizza")
public class OrderDetailController {
  @Autowired
  OrderDetailService orderDetailService;
  
  /*@GetMapping("/tutorials")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
    if (title == null)
      return tutorialService.findAll();
    else
      return tutorialService.findByTitleContaining(title);
  }*/

  @GetMapping("/order_detail/{id}")
  @ResponseStatus(HttpStatus.OK)
  public OrderDetail getOrderDetailById(@PathVariable("id") int id) {
    return orderDetailService.findById(id);
  }

  @PostMapping("/order_detail")
  @ResponseStatus(HttpStatus.CREATED)
  public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
    return orderDetailService.save(orderDetail);
  }

  @PutMapping("/order_detail/{id}")
  @ResponseStatus(HttpStatus.OK)
  public OrderDetail updateOrderDetail(@PathVariable("id") int id, @RequestBody OrderDetail orderDetail) {
    return orderDetailService.update(id, orderDetail);
  }

  @DeleteMapping("/order_detail/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteOrderDetail(@PathVariable("id") int id) {
    orderDetailService.deleteById(id);
  }

  @DeleteMapping("/order_detail")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAllOrderDetails() {
    orderDetailService.deleteAll();
  }



  /*@GetMapping("/tutorials/published")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> findByPublished() {
    return tutorialService.findByPublished(true);
  }
   */
}
