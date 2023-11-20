package com.bezkoder.spring.r2dbc.h2.model;

import jakarta.persistence.*;

@Entity
@Table(name ="CUSTOMERS")
//exactly the same

public class Customer {



  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="PHONENUMBER_ID")
  private int phoneNumberId;

  @Column(name="CUSTOMER_FNAME")
  private String firstName;

  @Column(name="CUSTOMER_LNAME")
  private String lastName;

  @Column(name="CUSTOMER_STREET")
  private String street;

  //@Column(name="CUSTOMER_ZIPCODE")
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "customerZipCode", referencedColumnName = "ZIPCODE_ID" )
 //a cutomer can only have one zip code
  private ZipCode zipCode;
 
  //this is a one to many relationship between customer and zip code 

  @Column(name="ADDRESS")
  private String address;

  @Column(name="CITY")
  private String city;

  //@OneToOne(mappedBy = "CUSTOMERS")
  //private String phoneNumber;
  //this is for one to one relationship (JPA)


  public int getPhoneNumberId() {
    return phoneNumberId;
  }

  public void setPhoneNumberId(int phoneNumberId) {
    this.phoneNumberId = phoneNumberId;
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

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
  public int getZipCode(){
    return zipCode.getZipCode();
  }
  

}
