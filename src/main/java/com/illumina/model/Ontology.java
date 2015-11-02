package com.illumina.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Created by agupta2 on 11/2/15.
 */

@Entity
public class Ontology {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ontologyId;

    private String description;
    private String versionId;

    protected Ontology() {
    }

    public Ontology(String description, String versionId) {
        this.description = description;
        this.versionId = versionId;
    }

    @Override
    public String toString() {
        return String.format("Ontology[ontologyId=%d, description='$s', versionId='%s']", ontologyId, description, versionId);
    }
}
