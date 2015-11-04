package com.illumina.service;

import com.illumina.domain.OntologyRequest;
import com.illumina.domain.OntologyResponse;

/**
 * Created by agupta2 on 10/30/15.
 */
public interface OntologyService {

    public OntologyResponse getMappedOntologyForDomain(String domainId);

    public OntologyResponse updateOntologyForDomain(String domainId, OntologyRequest request);


}
