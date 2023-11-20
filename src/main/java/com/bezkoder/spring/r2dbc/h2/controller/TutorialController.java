/*package com.bezkoder.spring.r2dbc.h2.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bezkoder.spring.r2dbc.h2.model.Tutorial;
import com.bezkoder.spring.r2dbc.h2.service.TutorialService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class TutorialController {
  @Autowired
  TutorialService tutorialService;
  
  /*@GetMapping("/tutorials")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> getAllTutorials(@RequestParam(required = false) String title) {
    if (title == null)
      return tutorialService.findAll();
    else
      return tutorialService.findByTitleContaining(title);
  } */
   /* 

  @GetMapping("/tutorials/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Tutorial getTutorialById(@PathVariable("id") int id) {
    return tutorialService.findById(id);
  }

  @PostMapping("/tutorials")
  //@ResponseStatus(HttpStatus.CREATED)
  public Tutorial createTutorial(@RequestBody Tutorial tutorial) {
    System.out.println("Made it here 1");
    return tutorialService.save(tutorial);
  }

  @PutMapping("/tutorials/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Tutorial updateTutorial(@PathVariable("id") int id, @RequestBody Tutorial tutorial) {
    return tutorialService.update(id, tutorial);
  }

  @DeleteMapping("/tutorials/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteTutorial(@PathVariable("id") int id) {
    tutorialService.deleteById(id);
  }

  @DeleteMapping("/tutorials")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void deleteAllTutorials() {
     tutorialService.deleteAll();
  }

  /*@GetMapping("/tutorials/published")
  @ResponseStatus(HttpStatus.OK)
  public List<Tutorial> findByPublished() {
    return tutorialService.findByPublished(true);
  }
   
}
*/
