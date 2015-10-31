package service;

import model.OntologyNode;

import java.util.List;

/**
 * Created by agupta2 on 10/30/15.
 */
public interface OntologyService {

    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode);

    public List<OntologyNode> getOntologyByDomainId(String domainId);

}
