package com.illumina.model;


import javax.persistence.*;

@Entity
@Table(name = "DOMAIN_ONTOLOGY_MAPPING")
public class DomainOntologyMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int domainOntologyMapId;

    private int domainId;
    private int ontologyId;

    protected DomainOntologyMapping() {
    }

    public DomainOntologyMapping(int domainId, int ontologyId) {
        this.domainId = domainId;
        this.ontologyId = ontologyId;
    }

    @Override
    public String toString() {
        return String.format("DomainOntologyMapping[mappedId=%d, domainId=%d, ontologyId=%d]", domainOntologyMapId, domainId, ontologyId);
    }
}
