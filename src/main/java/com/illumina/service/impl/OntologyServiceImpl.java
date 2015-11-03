package com.illumina.service.impl;

import com.illumina.dao.OntologyNodeDao;
import com.illumina.db.model.DomainOntologyMapping;
import com.illumina.db.model.Ontology;
import com.illumina.db.repo.DomainOntMappingRepo;
import com.illumina.db.repo.OntologyRepo;
import com.illumina.domain.OntologyNode;
import com.illumina.domain.OntologyResult;
import com.illumina.service.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * Created by agupta2 on 10/30/15.
 */

@Service
public class OntologyServiceImpl implements OntologyService{

    @Autowired
    OntologyNodeDao ontologyNodeDao;

    @Autowired
    OntologyRepo ontologyRepo;

    @Autowired
    DomainOntMappingRepo domainOntMappingRepo;

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
        Optional<Ontology> ontologylist = ontologyRepo.findByOntologyid(new Integer(101));
        List<Ontology> list = ontologyRepo.findAll();

        List<DomainOntologyMapping> domainOntologyMappings = domainOntMappingRepo.findAll();
        System.out.println(ontologylist);
        System.out.println(list);
        System.out.println(domainOntologyMappings);
        OntologyResult ontologyResult = new OntologyResult(ontologyNodes, HttpStatus.OK.value());
        return ontologyResult;
    }
}
