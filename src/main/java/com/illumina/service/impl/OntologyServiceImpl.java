package com.illumina.service.impl;

import com.illumina.dao.OntologyNodeDao;
import com.illumina.dao.OntologyRepositoryDao;
import com.illumina.model.Ontology;
import com.illumina.model.OntologyNode;
import com.illumina.model.OntologyResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.illumina.service.OntologyService;

import java.util.List;
import java.util.Optional;


/**
 * Created by agupta2 on 10/30/15.
 */

@Service
public class OntologyServiceImpl implements OntologyService{

    @Autowired
    OntologyNodeDao ontologyNodeDao;

   // @Autowired
    //OntologyRepositoryDao ontologyRepositoryDao;

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
        //Optional<Ontology> ontologylist = ontologyRepositoryDao.findById(new Integer(101));
        //System.out.println(ontologylist);
        OntologyResult ontologyResult = new OntologyResult(ontologyNodes, HttpStatus.OK.value());
        return ontologyResult;
    }
}
