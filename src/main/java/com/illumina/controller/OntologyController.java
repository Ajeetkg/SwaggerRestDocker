package com.illumina.controller;


import com.illumina.service.impl.OntologyServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.illumina.model.OntologyNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.illumina.service.OntologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


@RestController
@Api(value="Ontology", description = "Ontology API")
public class OntologyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    OntologyService ontologyService;

    @RequestMapping(value="/ont/ontology", method=RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value="Add Ontology to domain")
    public ResponseEntity<OntologyNode> addOntologyByDomainId(@RequestBody OntologyNode ontologyNode) {
        logger.info("Post ontology node: "+ontologyNode);
        HttpHeaders httpHeaders = new HttpHeaders();
        ontologyNode = ontologyService.addOntologyByDomainId(ontologyNode);
        return new ResponseEntity<OntologyNode>(ontologyNode, httpHeaders, HttpStatus.CREATED);
    }

    @RequestMapping(value="/ont/ontology", method=RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value="Get the available Ontology")
    public ResponseEntity<List<OntologyNode>> getOntologyByDomainId(@RequestParam(value = "id", defaultValue = "1") String domainId) {
        logger.info("Retrieve ontology node for: "+domainId);
        List<OntologyNode> conceptList = ontologyService.getOntologyByDomainId(domainId);
        return new ResponseEntity<List<OntologyNode>>(conceptList, HttpStatus.OK);
    }
}
