package com.illumina.domain;

import com.illumina.db.model.Ontology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by agupta2 on 11/4/15.
 */
public class OntologyRequest {

    List<Ontology> listOntology;
    List<Integer> listOntologyid;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public OntologyRequest() {
    }

    public OntologyRequest(List<Ontology> listOntology, Integer status) {
        this.listOntology = listOntology;

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("listOntology").append(" : ").append(listOntology);
        logger.info("OntologyRequest:    " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    private String printOntologyList(List<Ontology> listOntology) {
        StringBuilder stringBuilder = new StringBuilder();
        listOntology.forEach((ontology) -> stringBuilder.append(ontology).append(","));
        return stringBuilder.toString();
    }

    public List<Ontology> getListOntology() {
        return listOntology;
    }

    public void setListOntology(List<Ontology> listOntology) {
        this.listOntology = listOntology;
    }

    public List<Integer> getListOntologyid() {
        return listOntologyid;
    }

    public void setListOntologyid(List<Integer> listOntologyid) {
        this.listOntologyid = listOntologyid;
    }
}
