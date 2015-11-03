package com.illumina.db.repo;

import com.illumina.db.model.DomainOntologyMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by agupta2 on 11/3/15.
 */
public interface DomainOntMappingRepo extends JpaRepository<DomainOntologyMapping, Integer> {
    List<DomainOntologyMapping> findByDomainid(Integer domainid);
    void deleteByDomainid(Integer domainid);


}
