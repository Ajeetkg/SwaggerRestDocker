package com.illumina.dao;


import com.illumina.domain.OntologyNode;

import java.util.List;

/**
 * Created by agupta2 on 10/30/15.
 */
public interface OntologyNodeDao {

    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode);

    public List<OntologyNode> getOntologyByDomainId(String domainid);

    public List<OntologyNode> getMappedOntologyForDomain(String domainid);
}
