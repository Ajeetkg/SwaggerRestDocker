package com.illumina.db.repo;


import com.illumina.db.model.Ontology;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OntologyRepositoryDao extends JpaRepository<Ontology, Integer> {

    /*
    List<Ontology> findByDescription(String description);

    Optional<Ontology> findById(Integer ontologyId);
    */
}
