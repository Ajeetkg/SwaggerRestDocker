package com.illumina.db.model;

import javax.persistence.*;


/**
 * Created by agupta2 on 11/2/15.
 */

@Entity
@Table(name = "ONTOLOGY")
public class Ontology {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ontologyid;

    private String description;
    private String versionid;

    protected Ontology() {
    }

    public Ontology(String description, String versionid) {
        this.description = description;
        this.versionid = versionid;
    }

    @Override
    public String toString() {
        return String.format("Ontology[ontologyId=%d, description=%s, versionId=%s]", ontologyid, description, versionid);
    }
}
