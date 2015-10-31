package dao.impl;

import model.OntologyNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by agupta2 on 10/30/15.
 */
public class OntologyDaoImpl {
    private final AtomicInteger counter = new AtomicInteger();
    private Map<Integer, OntologyNode> conceptMap = new ConcurrentHashMap<Integer, OntologyNode>();

    public OntologyNode addOntologyByDomainId(OntologyNode ontologyNode) {
        conceptMap.put(counter.incrementAndGet(), ontologyNode);
        return ontologyNode;
    }

    public List<OntologyNode> getOntologyByDomainId(String domainId) {
        //Get all
        List<OntologyNode> conceptList = new ArrayList<OntologyNode>();
        for (Map.Entry<Integer, OntologyNode> entry : conceptMap.entrySet()) {
            conceptList.add(entry.getValue());
        }
        return conceptList;
    }
}
