TRUNCATE TABLE ONTOLOGY;
insert into ONTOLOGY VALUE(1,'HPO','1.0');
insert into ONTOLOGY VALUE(2,'SNOMED CT','1.0');
insert into ONTOLOGY VALUE(3,'UMIM','1.0');
insert into ONTOLOGY VALUE(4,'ULMS','1.0');
select * from ontologydb.ONTOLOGY;


TRUNCATE TABLE DOMAIN_ONTOLOGY_MAPPING;
insert into DOMAIN_ONTOLOGY_MAPPING value(1,101,1);
insert into DOMAIN_ONTOLOGY_MAPPING value(2,101,2);
insert into DOMAIN_ONTOLOGY_MAPPING value(3,101,3);
select * from ontologydb.DOMAIN_ONTOLOGY_MAPPING;

commit;