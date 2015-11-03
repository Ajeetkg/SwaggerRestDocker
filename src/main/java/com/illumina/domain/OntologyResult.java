package com.illumina.domain;

import java.util.List;

/**
 * Created by agupta2 on 11/3/15.
 */
public class OntologyResult {
    List<OntologyNode> ontologyNodes;
    Integer status;

    public OntologyResult(){}

    public OntologyResult(List<OntologyNode> ontologyNodes, Integer status){
        this.ontologyNodes=ontologyNodes;
        this.status=status;
    }

    public List<OntologyNode> getOntologyNodes() {
        return ontologyNodes;
    }

    public void setOntologyNodes(List<OntologyNode> ontologyNodes) {
        this.ontologyNodes = ontologyNodes;
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
        stringBuilder.append("OntologyNode").append(" : ").append(printOntologyNodes(this.ontologyNodes));
        return stringBuilder.toString();
    }

    private String printOntologyNodes(List<OntologyNode> ontologyNodes){
        StringBuilder stringBuilder = new StringBuilder();
        ontologyNodes.forEach((ontologyNode) -> stringBuilder.append(ontologyNode).append(","));
        return stringBuilder.toString();
    }
}
