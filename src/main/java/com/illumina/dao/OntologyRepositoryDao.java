package com.illumina.dao;


import com.illumina.model.Ontology;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OntologyRepositoryDao extends CrudRepository<Ontology, Integer>{

    List<Ontology> findByDescription(String description);
}
