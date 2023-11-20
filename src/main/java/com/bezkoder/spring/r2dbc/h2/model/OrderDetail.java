package com.bezkoder.spring.r2dbc.h2.model;

//import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name ="ORDER_DETAIL")
//exactly the same

public class OrderDetail {



  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ORDER_DETAIL_ID")
  private int orderDetailId;

  //@Column(name="PRODUCT_ID") 
  //do not think I need the column 
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "productId", referencedColumnName = "PRODUCT_ID")
  private Product product;
  //foreign key productId
  //A Order deatil can only have one product 
  //A product can not belong to multiple order details in an order 
  //we represent multiple of the same items by their quantity 
  //one to one 
  //can get productId from getter method in Product class

  @Column(name="ORDER_DETAIL_SUBTOTAL")
  private float orderDetailSubtotal;
  
  
  @Column(name="CUSTOMER_ORDER_DETAIL_ID")
  private int customerOrderDetailId;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customerOrderId", referencedColumnName ="CUSTOMER_ORDER_ID" )
  private CustomerOrder customerOrder;

  /*@Column(name="EMPLOYEE_ID")
  private int employeeId; */


  public int getOrderDetailId() {
    return orderDetailId;
  }

  public int getProductId() {
    return product.getProductId();
  }
   public int getCustomerOrderDetailId() {
    return customerOrderDetailId;
  }

  public float getOrderDetailSubtotal() {
    return orderDetailSubtotal;
  }

  public void setORderDetailSubtotal(float orderDetailSubtotal) {
    this.orderDetailSubtotal = orderDetailSubtotal;
  }

  public int getEmployeeId() {
    return customerOrder.getCustomerEmployeeId();
  }

  

 

 
}
