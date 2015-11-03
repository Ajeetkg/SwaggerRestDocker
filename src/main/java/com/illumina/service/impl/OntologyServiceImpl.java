package com.illumina.service.impl;

import com.illumina.dao.OntologyNodeDao;
import com.illumina.model.OntologyNode;
import com.illumina.model.OntologyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.illumina.service.OntologyService;

import java.util.List;


/**
 * Created by agupta2 on 10/30/15.
 */

@Service
public class OntologyServiceImpl implements OntologyService{

    @Autowired
    OntologyNodeDao ontologyNodeDao;

    @Override
    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode) {
        return ontologyNodeDao.addOntologyByDomainId(ontologyNode);
    }

    @Override
    public List<OntologyNode> getOntologyByDomainId(String domainId) {
        return ontologyNodeDao.getOntologyByDomainId(domainId);
    }

    @Override
    public OntologyResult getMappedOntologyForDomain(String domainId){
        List<OntologyNode> ontologyNodes = ontologyNodeDao.getMappedOntologyForDomain(domainId);
        OntologyResult ontologyResult = new OntologyResult(ontologyNodes, HttpStatus.OK.value());
        return ontologyResult;
    }
}
