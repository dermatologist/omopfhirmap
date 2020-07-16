package com.canehealth.omopfhirmap.mapping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BaseMapperTest {

    @Autowired
    BaseMapper baseMapper;

    @BeforeEach
    void setUp() {
        baseMapper.setCohortId(2);
        baseMapper.fetchCohort();
    }

    @Test
    void fetchCohort() {
        System.out.println(baseMapper.getCohortSize());
        assertTrue(baseMapper.getCohortSize() > 0);
    }

    
    @Test
    void fetchOmopResources() throws InterruptedException {
        baseMapper.trimList(5);
        baseMapper.fetchOmopResources();
        System.out.println("Person Count: ");
        System.out.println(baseMapper.getPersons().size());
        assertTrue(baseMapper.getPersons().size() > 0);

        System.out.println("Observations Count: ");
        System.out.println(baseMapper.getObservations().size());
        assertTrue(baseMapper.getObservations().size() > 0);

        System.out.println("Measurements Count: ");
        System.out.println(baseMapper.getMeasurements().size());
        assertTrue(baseMapper.getMeasurements().size() > 0);

        System.out.println("DrugExposure Count: ");
        System.out.println(baseMapper.getDrugExposures().size());
        assertTrue(baseMapper.getDrugExposures().size() > 0);

        System.out.println("VisitOccurrence Count: ");
        System.out.println(baseMapper.getVisitOccurrences().size());
        assertTrue(baseMapper.getVisitOccurrences().size() > 0);

        System.out.println("ProcedureOccurrence Count: ");
        System.out.println(baseMapper.getProcedureOccurrences().size());
        assertTrue(baseMapper.getProcedureOccurrences().size() > 0);
    }

    @Test
    void createBundle() {
    }
}