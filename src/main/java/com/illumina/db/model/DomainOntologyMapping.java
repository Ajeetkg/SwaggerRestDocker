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
        return String.format("DomainOntologyMapping[mappingid=%d, domainid=%d, ontologyid=%d]", mappingid, domainid, ontologyid);
    }
}
