package com.illumina.service;

import com.illumina.domain.OntologyRequest;
import com.illumina.domain.OntologyResult;

import java.util.List;

/**
 * Created by agupta2 on 10/30/15.
 */
public interface OntologyService {

    public OntologyResult getMappedOntologyForDomain(String domainId);

    public OntologyResult updateOntologyForDomain(String domainId, OntologyRequest request);


}
