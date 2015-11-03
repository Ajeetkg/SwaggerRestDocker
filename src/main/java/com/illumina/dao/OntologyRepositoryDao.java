package com.illumina.dao;


import com.illumina.model.Ontology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;
import java.util.List;

public interface OntologyRepositoryDao extends JpaRepository<Ontology, Integer> {

    List<Ontology> findByDescription(String description);

    Optional<Ontology> findById(Integer ontologyId);
}
