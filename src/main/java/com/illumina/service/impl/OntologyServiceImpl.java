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

import java.util.ArrayList;
import java.util.List;


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

        List<Ontology> listOntology = ontologyRepo.findAll();
        List<DomainOntologyMapping> domainOntologyMappings = domainOntMappingRepo.findByDomainid(new Integer(domainId));
        System.out.println(listOntology);
        System.out.println(domainOntologyMappings);
        List<Ontology> finalOntology = new ArrayList<>();

        finalOntology = getOntologyForDomain(domainOntologyMappings,listOntology);
        OntologyResult ontologyResult = new OntologyResult(finalOntology, HttpStatus.OK.value());
        return ontologyResult;
    }

    private List<Ontology> getOntologyForDomain(List<DomainOntologyMapping> domainOntologyMappings,  List<Ontology> listOntology){
        List<Ontology> finalOntology = new ArrayList<>();
        for(DomainOntologyMapping domainOntologyMapping: domainOntologyMappings){
            for(Ontology ontology:listOntology){
                if(ontology.getOntologyid() == domainOntologyMapping.getOntologyid()){
                    finalOntology.add(ontology);
                    break;
                }
            }
        }
        return finalOntology;
    }
}
