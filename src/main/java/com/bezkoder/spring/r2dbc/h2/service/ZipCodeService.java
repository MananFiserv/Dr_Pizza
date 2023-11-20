package com.bezkoder.spring.r2dbc.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.bezkoder.spring.r2dbc.h2.model.ZipCode;
import com.bezkoder.spring.r2dbc.h2.repository.ZipCodeRepository;


@Service
public class ZipCodeService {

  @Autowired
  ZipCodeRepository zipCodeRepository;

  public List<ZipCode> findAll() {
    return zipCodeRepository.findAll();
  }
  //flux is for multiple items



  public ZipCode findById(int id) {
    Optional<ZipCode> managed = zipCodeRepository.findById(id);
    if(managed.isPresent()){
      return managed.get();
    }else{
      return null;
    }
  }
  //mono is for a single item

  public ZipCode save(ZipCode zipCode) {
    return zipCodeRepository.save(zipCode);
  }

  public ZipCode update(int id, ZipCode zipcode) {
   Optional<ZipCode> managed = zipCodeRepository.findById(id);
   ZipCode toUpdate = null;
   if(managed.isPresent()){
     toUpdate = managed.get();
     toUpdate.setCity(zipcode.getCity());
     toUpdate.setState(zipcode.getState());
     
   }
   zipCodeRepository.saveAndFlush(toUpdate);
   return toUpdate;


  }

  public void deleteById(int id) {
    zipCodeRepository.deleteById(id);
  }

  public void deleteAll() {
   zipCodeRepository.deleteAll();
  }


}
