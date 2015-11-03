package com.illumina.db.repo;

import com.illumina.db.model.DomainOntologyMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by agupta2 on 11/3/15.
 */
public interface DomainOntMappingRepo extends JpaRepository<DomainOntologyMapping, Integer> {
    Optional<DomainOntologyMapping> findByDomainid(Integer domainid);
}
