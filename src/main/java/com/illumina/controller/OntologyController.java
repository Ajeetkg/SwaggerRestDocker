package com.illumina.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.illumina.db.model.DomainOntologyMapping;
import com.illumina.db.model.Ontology;
import com.illumina.domain.OntologyResult;
import com.illumina.util.Constants;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.illumina.domain.OntologyNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.illumina.service.OntologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.util.JAXBSource;
import java.util.ArrayList;
import java.util.List;


@RestController
@Api(value="Ontology", description = "Ontology API")
public class OntologyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    OntologyService ontologyService;


    /*
    @RequestMapping(value="/ont/ontology", method=RequestMethod.GET)
    @ApiOperation(httpMethod = Constants.GET, value="Get all the available Ontology")
    public ResponseEntity<List<OntologyNode>> getOntologyByDomainId(@RequestParam(value = "id", defaultValue = "1") String domainId) {
        logger.info("Retrieve ontology node for: "+domainId);
        List<OntologyNode> conceptList = ontologyService.getOntologyByDomainId(domainId);
        return new ResponseEntity<List<OntologyNode>>(conceptList, HttpStatus.OK);
    }


    @RequestMapping(value="/ont/ontology/{domainid}", method=RequestMethod.POST)
    @ApiOperation(httpMethod = Constants.POST, value="Add Ontology to a domain")
    public ResponseEntity<OntologyNode> addOntologyByDomainId(@PathVariable("domainid")String domainId, @RequestBody OntologyNode ontologyNode) {
        logger.info("addOntologyByDomainId.Post ontology node: "+ontologyNode);
        HttpHeaders httpHeaders = new HttpHeaders();
        ontologyNode = ontologyService.addOntologyByDomainId(ontologyNode);
        return new ResponseEntity<OntologyNode>(ontologyNode, httpHeaders, HttpStatus.CREATED);
    }
    */

    @RequestMapping(value = "/ont/ontology/{domainid}", method=RequestMethod.GET)
    @ApiOperation(httpMethod = Constants.GET, value="Get the mapped ontology for domainId")
    public ResponseEntity<OntologyResult> getMappedOntologyForDomain(@PathVariable("domainid")String domainId){
        logger.info("getMappedOntologyForDomain.Mapped Ontology for domain:"+domainId);
        OntologyResult ontologyResult = ontologyService.getMappedOntologyForDomain(domainId);
        return new ResponseEntity<>(ontologyResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/ont/ontology/{domainid}", method=RequestMethod.PUT)
    @ApiOperation(httpMethod = Constants.PUT, value="Replace mapped Ontology for a domainId")
    public ResponseEntity<OntologyResult> updateOntologyForDomain(@PathVariable("domainid")String domainId, @RequestBody Ontology ontology){
        logger.info("updateOntologyForDomain.Mapped Ontology for domain:"+ontology);
        List<String> listOntologyid = new ArrayList<>();
        listOntologyid.add(ontology.getOntologyid()+"");
        OntologyResult ontologyResult  = ontologyService.updateOntologyForDomain(domainId, listOntologyid);
        return new ResponseEntity<>(ontologyResult, HttpStatus.OK);
    }
}
