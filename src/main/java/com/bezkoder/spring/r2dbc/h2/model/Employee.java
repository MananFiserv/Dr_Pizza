package com.bezkoder.spring.r2dbc.h2.model;

import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
//import net.snowflake.client.jdbc.internal.apache.arrow.flatbuf.Timestamp;
import java.util.List;

@Entity
@Table(name ="EMPLOYEE")
//exactly the same

public class Employee {



  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="EMPLOYEE_ID")
  private int employeeId;

  @Column(name="EMPLOYEE_FNAME")
  private String firstName;

  @Column(name="EMPLOYEE_LNAME")
  private String lastName;

   @Column(name="EMPLOYEE_HIREDATE")
   @CreationTimestamp
  private Date hireDate;

  @Column(name="EMPLOYEE_STATUS")
  private String employeeStatus;

  @OneToMany(mappedBy = "employee") 
  //private CustomerOrder customerOrder;
  private List<CustomerOrder> customerOrders;


  public int getEmployeeId() {
    return employeeId;
  }

  public void setId(int employeeId) {
    this.employeeId = employeeId;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Date getHireDate() {
    return hireDate;
  }

  public void setHireDate(Date hireDate) {
    this.hireDate = hireDate;
  }

  public String getEmployeeStatus() {
    return employeeStatus;
  }

  public void setEmployeeStatus(String employeeStatus) {
    this.employeeStatus = employeeStatus;
  }
}
