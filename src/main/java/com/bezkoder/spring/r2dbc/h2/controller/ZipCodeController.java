package com.bezkoder.spring.r2dbc.h2.controller;

import java.util.List;

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

import com.bezkoder.spring.r2dbc.h2.model.Customer;
import com.bezkoder.spring.r2dbc.h2.model.ZipCode;
import com.bezkoder.spring.r2dbc.h2.service.ZipCodeService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/DoctorPizza")
public class ZipCodeController {
  @Autowired
  ZipCodeService zipCodeService;
  
  /*@GetMapping("/tutorials")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
    if (title == null)
      return tutorialService.findAll();
    else
      return tutorialService.findByTitleContaining(title);
  }*/

  
  @GetMapping("/zip_code")
  @ResponseStatus(HttpStatus.OK)
  public List<ZipCode> getAllZipCodes() {
   
      return zipCodeService.findAll();
  
  }

  @GetMapping("/zip_code/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ZipCode getZipCodeById(@PathVariable("id") int id) {
    return zipCodeService.findById(id);
  }

  @PostMapping("/zip_code")
  @ResponseStatus(HttpStatus.CREATED)
  public ZipCode createZipCode(@RequestBody ZipCode zipCode) {
    return zipCodeService.save(zipCode);
  }

  @PutMapping("/zip_code/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ZipCode updateZipCode(@PathVariable("id") int id, @RequestBody ZipCode zipCode) {
    return zipCodeService.update(id, zipCode);
  }

  @DeleteMapping("/zip_code/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteZipCode(@PathVariable("id") int id) {
    zipCodeService.deleteById(id);
  }

  @DeleteMapping("/zip_code")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAllZipCodes() {
     zipCodeService.deleteAll();
  }

  /*@GetMapping("/tutorials/published")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> findByPublished() {
    return tutorialService.findByPublished(true);
  }
   */
}
