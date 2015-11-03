package com.illumina.dao.impl;

import com.illumina.dao.OntologyNodeDao;
import com.illumina.domain.OntologyNode;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by agupta2 on 10/30/15.
 */
@Repository
public class OntologyNodeDaoImpl implements OntologyNodeDao {
    private final AtomicInteger counter = new AtomicInteger();
    private Map<Integer, OntologyNode> conceptMap = new ConcurrentHashMap<Integer, OntologyNode>();

    @Override
    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode) {
        conceptMap.put(counter.incrementAndGet(), ontologyNode);
        return ontologyNode;
    }

    @Override
    public List<OntologyNode> getOntologyByDomainId(String domainId) {
        //Get all
        List<OntologyNode> conceptList = new ArrayList<OntologyNode>();
        for (Map.Entry<Integer, OntologyNode> entry : conceptMap.entrySet()) {
            conceptList.add(entry.getValue());
        }
        return conceptList;
    }

    @Override
    public List<OntologyNode> getMappedOntologyForDomain(String domainId) {
        //Get all
        List<OntologyNode> conceptList = new ArrayList<OntologyNode>();
        for (Map.Entry<Integer, OntologyNode> entry : conceptMap.entrySet()) {
            conceptList.add(entry.getValue());
        }
        return conceptList;
    }
}
