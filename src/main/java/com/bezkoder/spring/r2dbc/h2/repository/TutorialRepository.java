package com.bezkoder.spring.r2dbc.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.bezkoder.spring.r2dbc.h2.model.Tutorial;

import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
  //(model, model's id)

  //this is the interface that connect to the tutorial service???



}
