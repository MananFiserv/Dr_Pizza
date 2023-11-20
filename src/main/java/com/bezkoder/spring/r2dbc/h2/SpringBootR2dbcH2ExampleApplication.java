package com.bezkoder.spring.r2dbc.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//one to many-> employee, multiple orders 



@EnableJpaRepositories(basePackages = "com.bezkoder.spring.r2dbc.h2.repository")
//tells jpa where to look for your repositories
@EntityScan(basePackages = "com.bezkoder.spring.r2dbc.h2.model")
//compares model to entities(tables in database)


//@EnableR2dbcRepositories
@SpringBootApplication
public class SpringBootR2dbcH2ExampleApplication {

  //@Bean
  /*ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {

    ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
    initializer.setConnectionFactory(connectionFactory);
    initializer.setDatabasePopulator(new ResourceDatabasePopulator(new ClassPathResource("schema.sql")));

    //have to create our own schema.....

    return initializer;
  } */


  public static void main(String[] args) {
    SpringApplication.run(SpringBootR2dbcH2ExampleApplication.class, args);
  }

}
