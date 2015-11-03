package com.illumina.domain;

public class OntologyNode {

    private int id;
    private String ontologyName;

    public OntologyNode() {
    }

    public OntologyNode(int id, String ontologyName) {
        this.id = id;
        this.ontologyName = ontologyName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOntologyName(String ontologyName) {
        this.ontologyName = ontologyName;
    }

    public int getId() {
        return id;
    }

    public String getOntologyName() {
        return ontologyName;
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id").append(" : ").append(this.id).append(", ");
        stringBuilder.append("ontologyName").append(" : ").append(this.ontologyName);
        return stringBuilder.toString();
    }

}