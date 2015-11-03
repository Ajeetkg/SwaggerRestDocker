package com.illumina.service;

import com.illumina.model.OntologyNode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by agupta2 on 10/30/15.
 */
public interface OntologyService {

    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode);

    public List<OntologyNode> getOntologyByDomainId(String domainId);

    public List<OntologyNode> getMappedOntologyForDomain(String domainId);

}
