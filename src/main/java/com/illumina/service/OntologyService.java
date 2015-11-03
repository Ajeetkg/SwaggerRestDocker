package com.illumina.service;

import com.illumina.domain.OntologyNode;
import com.illumina.domain.OntologyResult;

import java.util.List;

/**
 * Created by agupta2 on 10/30/15.
 */
public interface OntologyService {

    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode);

    public List<OntologyNode> getOntologyByDomainId(String domainId);

    public OntologyResult getMappedOntologyForDomain(String domainId);

}
