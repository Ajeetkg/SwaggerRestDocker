package com.illumina.service.impl;

import com.illumina.dao.OntologyNodeDao;
import com.illumina.db.model.DomainOntologyMapping;
import com.illumina.db.model.Ontology;
import com.illumina.db.repo.DomainOntMappingRepo;
import com.illumina.db.repo.OntologyRepo;
import com.illumina.domain.OntologyNode;
import com.illumina.domain.OntologyRequest;
import com.illumina.domain.OntologyResult;
import com.illumina.exception.OntologyException;
import com.illumina.service.OntologyService;
import com.illumina.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Transactional
    public OntologyResult updateOntologyForDomain(String domainid, OntologyRequest request) throws OntologyException{
        domainOntMappingRepo.deleteAllByDomainid(new Integer(domainid));
        List<DomainOntologyMapping> domainOntologyMappings;

        if(null!= request.getListOntology()
                && request.getListOntology().size() > 0){
            domainOntologyMappings = getDomainOntologyMapping(domainid,request);
        }else if(null!= request.getListOntologyid()
                && request.getListOntologyid().size() > 0){
            domainOntologyMappings = getDomainOntologyMappingByOntologyIds(domainid,request);
        } else{
            throw new OntologyException(Constants.ServiceResponse.NO_CONTENT_CODE);
        }

        List<DomainOntologyMapping> savedMappings = domainOntMappingRepo.save(domainOntologyMappings);
        OntologyResult ontologyResult = new OntologyResult(HttpStatus.OK.value());
        return ontologyResult;
    }

    private List<DomainOntologyMapping> getDomainOntologyMapping(String domainid, OntologyRequest request ){
        List<DomainOntologyMapping> domainOntologyMappings = new ArrayList<>();
        DomainOntologyMapping domainOntologyMapping = new DomainOntologyMapping();
        List<Ontology> listOntology = request.getListOntology();
        for(Ontology ontology: listOntology){
            domainOntologyMapping = new DomainOntologyMapping();
            domainOntologyMapping.setDomainid(new Integer(domainid));
            domainOntologyMapping.setOntologyid(ontology.getOntologyid());
            domainOntologyMappings.add(domainOntologyMapping);
        }
        return domainOntologyMappings;
    }

    private List<DomainOntologyMapping> getDomainOntologyMappingByOntologyIds(String domainid, OntologyRequest request ){
        List<DomainOntologyMapping> domainOntologyMappings = new ArrayList<>();
        DomainOntologyMapping domainOntologyMapping = new DomainOntologyMapping();
        List<Integer> listOntologyid = request.getListOntologyid();
        for(Integer ontologyid: listOntologyid){
            domainOntologyMapping = new DomainOntologyMapping();
            domainOntologyMapping.setDomainid(new Integer(domainid));
            domainOntologyMapping.setOntologyid(ontologyid);
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
