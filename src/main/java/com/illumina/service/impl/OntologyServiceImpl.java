package com.illumina.service.impl;

import com.illumina.dao.OntologyNodeDao;
import com.illumina.db.model.DomainOntologyMapping;
import com.illumina.db.model.Ontology;
import com.illumina.db.repo.DomainOntMappingRepo;
import com.illumina.db.repo.OntologyRepo;
import com.illumina.domain.OntologyNode;
import com.illumina.domain.OntologyResult;
import com.illumina.exception.OntologyException;
import com.illumina.service.OntologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



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
    public OntologyResult getMappedOntologyForDomain(String domainId) throws OntologyException{

        List<Ontology> listOntology = ontologyRepo.findAll();
        List<DomainOntologyMapping> domainOntologyMappings = domainOntMappingRepo.findByDomainid(new Integer(domainId));
        List<Ontology> finalOntology = getOntologyForDomain(domainOntologyMappings, listOntology);
        OntologyResult ontologyResult = new OntologyResult(finalOntology, HttpStatus.OK.value());
        return ontologyResult;
    }

    @Override
    public OntologyResult updateOntologyForDomain(String domainid, List<String> listOntologyid) throws OntologyException{
        domainOntMappingRepo.deleteByDomainid(new Integer(domainid));
        List<DomainOntologyMapping> domainOntologyMappings = getDomainOntologyMapping(domainid,listOntologyid);
        //List<DomainOntologyMapping> savedMappings = domainOntMappingRepo.save(domainOntologyMappings);
        OntologyResult ontologyResult = new OntologyResult(HttpStatus.OK.value());
        return ontologyResult;
    }

    private List<DomainOntologyMapping> getDomainOntologyMapping(String domainid, List<String> listOntologyid ){
        List<DomainOntologyMapping> domainOntologyMappings = new ArrayList<>();
        DomainOntologyMapping domainOntologyMapping = new DomainOntologyMapping();
        for(String ontologyid: listOntologyid){
            domainOntologyMapping.setDomainid(new Integer(domainid));
            domainOntologyMapping.setOntologyid(new Integer(ontologyid));
            domainOntologyMappings.add(domainOntologyMapping);
        }
        return domainOntologyMappings;
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
