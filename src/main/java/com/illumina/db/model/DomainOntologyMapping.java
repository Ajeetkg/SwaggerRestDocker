package com.illumina.db.model;


import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import javax.persistence.*;

@Entity
@Table(name = "DOMAIN_ONTOLOGY_MAPPING")
@DynamicUpdate
@SelectBeforeUpdate
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
public class DomainOntologyMapping {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mappingid")
    private int mappingid;

    @Column(name = "domainid")
    private int domainid;

    @Column(name="ontologyid")
    private int ontologyid;

    public DomainOntologyMapping() {
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
