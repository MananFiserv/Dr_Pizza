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
import com.bezkoder.spring.r2dbc.h2.model.Product;
import com.bezkoder.spring.r2dbc.h2.service.ProductService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/DoctorPizza")
public class ProductController {
  @Autowired
  ProductService productService;
  
  /*@GetMapping("/tutorials")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
    if (title == null)
      return tutorialService.findAll();
    else
      return tutorialService.findByTitleContaining(title);
  }*/

  
  @GetMapping("/products")
  @ResponseStatus(HttpStatus.OK)
  public List<Product> getAllProduct() {
   
      return productService.findAll();
  
  }

  @GetMapping("/products/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Product getProductById(@PathVariable("id") int id) {
    return productService.findById(id);
  }

  @PostMapping("/products")
  @ResponseStatus(HttpStatus.CREATED)
  public Product createProduct(@RequestBody Product product) {
    return productService.save(product);
  }

  @PutMapping("/products/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Product updateProduct(@PathVariable("id") int id, @RequestBody Product product) {
    return productService.update(id, product);
  }

  @DeleteMapping("/products/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteProduct(@PathVariable("id") int id) {
    productService.deleteById(id);
  }

  @DeleteMapping("/products")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAllProducts() {
     productService.deleteAll();
  }

  /*@GetMapping("/tutorials/published")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> findByPublished() {
    return tutorialService.findByPublished(true);
  }
   */
}
