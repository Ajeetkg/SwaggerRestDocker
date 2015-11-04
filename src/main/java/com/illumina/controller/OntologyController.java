package com.illumina.controller;


import com.illumina.domain.OntologyRequest;
import com.illumina.domain.OntologyResponse;
import com.illumina.service.OntologyService;
import com.illumina.util.Constants;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Api(value="Ontology", description = "Ontology API")
public class OntologyController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    OntologyService ontologyService;

    @RequestMapping(value = "/ont/ontology/{domainid}", method=RequestMethod.GET)
    @ApiOperation(httpMethod = Constants.GET, value="Get the mapped ontology for domainId")
    public ResponseEntity<OntologyResponse> getMappedOntologyForDomain(@PathVariable("domainid")String domainId){
        try {
            logger.info("getMappedOntologyForDomain.Mapped Ontology for domain:" + domainId);
            OntologyResponse ontologyResponse = ontologyService.getMappedOntologyForDomain(domainId);
            return new ResponseEntity<>(ontologyResponse, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "/ont/ontology/{domainid}", method=RequestMethod.PUT)
    @ApiOperation(httpMethod = Constants.PUT, value="Replace mapped Ontology for a domainId")
    public ResponseEntity<OntologyResponse> updateOntologyForDomain(@PathVariable("domainid")String domainId, @RequestBody OntologyRequest request){

        try {
            logger.info("updateOntologyForDomain.Mapped Ontology for domain:" + request);
            OntologyResponse ontologyResponse = ontologyService.updateOntologyForDomain(domainId, request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
