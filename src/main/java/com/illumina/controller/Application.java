package com.illumina.controller;

import com.illumina.dao.OntologyRepositoryDao;
import com.illumina.model.Ontology;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.illumina"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*
    @Bean
    public CommandLineRunner demo(final OntologyRepositoryDao ontologyRepositoryDao){
        return(args) ->{
            ontologyRepositoryDao.save(new Ontology("SnomedCT","1.0"));
        };
    }
    */
}