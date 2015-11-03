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
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ontologyid").append(":").append(this.ontologyid).append(", ");
        stringBuilder.append("description").append(":").append(this.description).append(", ");
        stringBuilder.append("versionid").append(":").append(this.versionid);
        return stringBuilder.toString();
    }

    public int getOntologyid() {
        return ontologyid;
    }

    public void setOntologyid(int ontologyid) {
        this.ontologyid = ontologyid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVersionid() {
        return versionid;
    }

    public void setVersionid(String versionid) {
        this.versionid = versionid;
    }


}
