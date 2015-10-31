package service.impl;

import dao.OntologyDao;
import model.OntologyNode;

import java.util.List;


/**
 * Created by agupta2 on 10/30/15.
 */
public class OntologyServiceImpl {

    OntologyDao ontologyDao;

    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode) {
        return ontologyDao.addOntologyByDomainId(ontologyNode);
    }

    public List<OntologyNode> getOntologyByDomainId(String domainId) {
        return ontologyDao.getOntologyByDomainId(domainId);
    }
}
