package com.bezkoder.spring.r2dbc.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name ="PRODUCTS")
//exactly the same

public class Product {



  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="PRODUCT_ID")
  //@OneToOne(mappedBy = "product")
  private int productId;

  @Column(name="PRODUCT_DESCRIPTION")
  private String productDescription;

  @Column(name="PRODUCT_PRICE")
  private float productPrice;

  @Column(name="SIZE")
  private String productSize;

  @OneToOne(mappedBy = "product")
  private OrderDetail orderDetail;
  //The product side of the relationship is the non-owning side.
  //one product can only be in one order detail
  //added ORDER_DETAIL_ID to PRODUCTS table
  //it can be null because it does not have to be in an order detail
  //needed it for One to One relationship (JPA) between product and order detail



  public int getProductId() {
    return productId;
  }

    public int getOrderDetailId() {
    return orderDetail.getCustomerOrderDetailId();
  }

  public String getProductDescription() {
    return productDescription;
  }

  public void setProductDescription(String productDescription) {
    this.productDescription = productDescription;
  }

  public float getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(float productPrice) {
    this.productPrice = productPrice;
  }

  public String getProductSize() {
    return productSize;
  }

  public void setProductSize(String productSize) {
    this.productSize = productSize;
  }


}
