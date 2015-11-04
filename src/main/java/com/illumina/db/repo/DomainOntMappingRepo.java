package com.illumina.db.repo;

import com.illumina.db.model.DomainOntologyMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

/**
 * Created by agupta2 on 11/3/15.
 */
public interface DomainOntMappingRepo extends JpaRepository<DomainOntologyMapping, Integer> {
    List<DomainOntologyMapping> findByDomainid(Integer domainid);

    @Modifying
    @Query("delete from DomainOntologyMapping dom where dom.domainid = :domainid")
    void deleteAllByDomainid(@Param("domainid") Integer domainid);



}
