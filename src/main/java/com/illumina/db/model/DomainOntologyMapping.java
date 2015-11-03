package com.illumina.db.model;


import javax.persistence.*;

@Entity
@Table(name = "DOMAIN_ONTOLOGY_MAPPING")
public class DomainOntologyMapping {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int mappingid;

    private int domainid;
    private int ontologyid;

    protected DomainOntologyMapping() {
    }

    public DomainOntologyMapping(int domainid, int ontologyid) {
        this.domainid = domainid;
        this.ontologyid = ontologyid;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mappingid").append(":").append(this.mappingid).append(", ");
        stringBuilder.append("domainid").append(":").append(this.domainid).append(", ");
        stringBuilder.append("ontologyid").append(":").append(this.ontologyid);
        return stringBuilder.toString();
    }

    public int getMappingid() {
        return mappingid;
    }

    public void setMappingid(int mappingid) {
        this.mappingid = mappingid;
    }

    public int getDomainid() {
        return domainid;
    }

    public void setDomainid(int domainid) {
        this.domainid = domainid;
    }

    public int getOntologyid() {
        return ontologyid;
    }

    public void setOntologyid(int ontologyid) {
        this.ontologyid = ontologyid;
    }
}
