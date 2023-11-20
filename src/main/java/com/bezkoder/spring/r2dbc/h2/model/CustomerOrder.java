package com.bezkoder.spring.r2dbc.h2.model;

import java.sql.Date;
import java.util.ArrayList;
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.util.Locale;
//import java.text.SimpleDateFormat;
import java.util.List;

import jakarta.persistence.*;
//import net.snowflake.client.jdbc.internal.apache.arrow.flatbuf.Timestamp;

@Entity
@Table(name ="CUSTOMER_ORDER")
//exactly the same

public class CustomerOrder {



  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="CUSTOMER_ORDER_ID")
  private int customerOrderId;

  //@Column(name="CUSTOMER_PHONENUMBER")
  @OneToOne(cascade = CascadeType.ALL)
  //private int customerPhoneNumber;
  @JoinColumn(name = "phoneNumberId", referencedColumnName = "PHONENUMBER_ID")
  private Customer customer;


  //@Column(name="CUSTOMER_EMPLOYEE_ID")
  ///@OneToOne(cascade = CascadeType.ALL)
  //private int customerEmployeeId;
 /// @JoinColumn(name = "customerEmployeeId", referencedColumnName = "EMPLOYEE_ID")
 @ManyToOne
 @JoinColumn(name="employeeId", nullable = false)
  private Employee employee;

  @Column(name="CUSTOMER_ORDER_DATE")
  @Temporal(TemporalType.DATE)
  private Date customerOrderDate;

  @Column(name="CUSTOMER_ORDER_SUBTOTAL")
  private float customerOrderSubtotal;

  @Column(name="CUSTOMER_ORDER_TAX")
  private float customerOrderTax;

  @Column(name="CUSTOMER_ORDER_TOTAL")
  private float customerOrderTotal;

  @Column(name="CUSTOMER_ORDER_PAY_STATUS")
  private String customerOrderPayStatus;

  @OneToOne(mappedBy = "customerOrder")
  private OrderDetail orderDetail;


  public int getCustomerOrderId() {
    return customerOrderId;
  }

  public int getCustomerPhoneNumber() {
    return customer.getPhoneNumberId();
  }


  public int getCustomerEmployeeId() {
    return employee.getEmployeeId();
  }

  public Date getCustomerOrderDate() {
    return customerOrderDate;
  }

   public void setCustomerOrderDate(Date customerOrderDate) {
    this.customerOrderDate = customerOrderDate;
  }

  public float getCustomerOrderSubtotal() {
    return customerOrderSubtotal;
  }

 public void setCustomerOrderSubtotal(float orderSubtotal) {
    this.customerOrderSubtotal = orderSubtotal;
  }

   public float getCustomerOrderTax() {
    return customerOrderTax;
  }

   public void setCustomerOrderTax(float tax) {
    this.customerOrderTax = tax;
  }

   public float getCustomerOrderTotal() {
    return customerOrderTotal;
  }

    public void setCustomerOrderTotal(float orderTotal) {
    this.customerOrderTotal = orderTotal;
  }

   public String getCustomerOrderPayStatus() {
    return customerOrderPayStatus;
  }

   public void setCustomerOrderPayStatus(String payStatus) {
    this.customerOrderPayStatus = payStatus;
  }

  public List<CustomerOrder> ordersContainsPhoneNumber(List<CustomerOrder> orders, List<Customer>customers){
    List<CustomerOrder> ordersContainingNumber = new ArrayList<>();
    for (CustomerOrder order:orders){
        for(Customer customer: customers){
            if(order.getCustomerPhoneNumber() == customer.getPhoneNumberId()){
              ordersContainingNumber.add(order);
            };
            
        }
       
    }
     return ordersContainingNumber;
  }
 
}
