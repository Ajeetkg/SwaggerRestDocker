package com.illumina.exception;

/**
 * Created by agupta2 on 11/3/15.
 */
public class OntologyException extends NotFoundException {
    public OntologyException(String ontologyid){
        super("No record found for "+ontologyid);
    }
}
