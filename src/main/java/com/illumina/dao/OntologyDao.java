package com.illumina.dao;


import com.illumina.model.OntologyNode;

import java.util.List;

/**
 * Created by agupta2 on 10/30/15.
 */
public interface OntologyDao {

    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode);

    public List<OntologyNode> getOntologyByDomainId(String conceptId);
}
