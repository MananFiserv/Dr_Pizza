package com.bezkoder.spring.r2dbc.h2.model;



import jakarta.persistence.*;

@Entity
@Table(name ="ZIPCODES")
//exactly the same

public class ZipCode {



  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name="ZIPCODE_ID")
  private int id;

  @Column(name="CITY")
  private String city;

  @Column(name="STATE")
  private String state;

  @OneToOne(mappedBy="zipCode")
  private Customer customer;
  //one zip code can have many customers


  public int getZipCode() {
    return id;
  }



  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }






 
}

