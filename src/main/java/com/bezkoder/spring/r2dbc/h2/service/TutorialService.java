package com.bezkoder.spring.r2dbc.h2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bezkoder.spring.r2dbc.h2.model.Tutorial;
import com.bezkoder.spring.r2dbc.h2.repository.TutorialRepository;


@Service
public class TutorialService {

  @Autowired
  TutorialRepository tutorialRepository;

  public List<Tutorial> findAll() {
    return tutorialRepository.findAll();
  }
  //flux is for multiple items



  public Tutorial findById(int id) {
    Optional<Tutorial> managed = tutorialRepository.findById(id);
    if(managed.isPresent()){
      return managed.get();
    }else{
      return null;
    }
  }
  //mono is for a single item

  public Tutorial save(Tutorial tutorial) {
    System.out.println("Made it here 2");
    return tutorialRepository.save(tutorial);
  }

  public Tutorial update(int id, Tutorial tutorial) {
   Optional<Tutorial> managed = tutorialRepository.findById(id);
   Tutorial toUpdate = null;
   if(managed.isPresent()){
     toUpdate = managed.get();
     toUpdate.setCity(tutorial.getCity());
     toUpdate.setAddress(tutorial.getAddress());
     toUpdate.setFirstName(tutorial.getFirstName());
     toUpdate.setLastName(tutorial.getLastName());
   }
   tutorialRepository.saveAndFlush(toUpdate);
   return toUpdate;


  }

  public void deleteById(int id) {
    tutorialRepository.deleteById(id);
  }

  public void deleteAll() {
   tutorialRepository.deleteAll();
  }


}
