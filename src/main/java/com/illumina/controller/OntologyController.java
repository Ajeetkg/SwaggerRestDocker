package com.illumina.controller;


import com.illumina.domain.OntologyRequest;
import com.illumina.domain.OntologyResult;
import com.illumina.util.Constants;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.illumina.service.OntologyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@Api(value="Ontology", description = "Ontology API")
public class OntologyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    OntologyService ontologyService;

    @RequestMapping(value = "/ont/ontology/{domainid}", method=RequestMethod.GET)
    @ApiOperation(httpMethod = Constants.GET, value="Get the mapped ontology for domainId")
    public ResponseEntity<OntologyResult> getMappedOntologyForDomain(@PathVariable("domainid")String domainId){
        logger.info("getMappedOntologyForDomain.Mapped Ontology for domain:"+domainId);
        OntologyResult ontologyResult = ontologyService.getMappedOntologyForDomain(domainId);
        return new ResponseEntity<>(ontologyResult, HttpStatus.OK);
    }

    @RequestMapping(value = "/ont/ontology/{domainid}", method=RequestMethod.PUT)
    @ApiOperation(httpMethod = Constants.PUT, value="Replace mapped Ontology for a domainId")
    public ResponseEntity<OntologyResult> updateOntologyForDomain(@PathVariable("domainid")String domainId, @RequestBody OntologyRequest request){
        logger.info("updateOntologyForDomain.Mapped Ontology for domain:"+request);
        OntologyResult ontologyResult  = ontologyService.updateOntologyForDomain(domainId, request);
        return new ResponseEntity<>(ontologyResult, HttpStatus.OK);
    }
}
