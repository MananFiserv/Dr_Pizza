package com.bezkoder.spring.r2dbc.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.r2dbc.h2.model.Product;
import com.bezkoder.spring.r2dbc.h2.repository.ProductRepository;


@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;

  public List<Product> findAll() {
    return productRepository.findAll();
  }
  //flux is for multiple items



  public Product findById(int id) {
    Optional<Product> managed = productRepository.findById(id);
    if(managed.isPresent()){
      return managed.get();
    }else{
      return null;
    }
  }
  //mono is for a single item

  public Product save(Product product) {
    return productRepository.save(product);
  }

  public Product update(int id, Product product) {
   Optional<Product> managed = productRepository.findById(id);
   Product toUpdate = null;
   if(managed.isPresent()){
     toUpdate = managed.get();
     toUpdate.setProductDescription(product.getProductDescription());
     toUpdate.setProductPrice(product.getProductPrice());
     toUpdate.setProductSize(product.getProductSize());
    
   }
   productRepository.saveAndFlush(toUpdate);
   return toUpdate;


  }

  public void deleteById(int id) {
    productRepository.deleteById(id);
  }

  public void deleteAll() {
   productRepository.deleteAll();
  }


}
