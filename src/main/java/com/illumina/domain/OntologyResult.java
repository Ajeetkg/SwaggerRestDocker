package com.illumina.domain;

import com.illumina.db.model.Ontology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by agupta2 on 11/3/15.
 */
public class OntologyResult {
    List<Ontology> listOntology;
    Integer status;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OntologyResult(){}

    public OntologyResult(List<Ontology> listOntology, Integer status){
        this.listOntology = listOntology;
        this.status=status;
    }

    public OntologyResult(Integer status){
        this.status=status;
    }
    public List<Ontology> getListOntology() {
        return listOntology;
    }

    public void setListOntology(List<Ontology> listOntology) {
        this.listOntology = listOntology;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("status").append(" : ").append(this.status).append(", ");
        stringBuilder.append("listOntology").append(" : ").append(listOntology);
        logger.info("OntologyResult:    "+stringBuilder.toString());
        return stringBuilder.toString();
    }

    private String printOntologyList(List<Ontology> listOntology){
        StringBuilder stringBuilder = new StringBuilder();
        listOntology.forEach((ontology) -> stringBuilder.append(ontology).append(","));
        return stringBuilder.toString();
    }
}
