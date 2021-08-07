package com.canehealth.omopfhirmap.mapping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class MainMapperTest {

    @Autowired
    MainMapper mainMapper;

    @BeforeEach
    void setUp() {
        mainMapper.setCohortId(2);
        mainMapper.fetchCohort();
    }

    @Test
    void fetchCohort() {
        System.out.println(mainMapper.getCohortSize());
        assertTrue(mainMapper.getCohortSize() > 0);
    }

    
    @Test
    void fetchOmopResources() throws InterruptedException {
        mainMapper.trimList(5);
        mainMapper.fetchOmopResources();
        System.out.println("Person Count: ");
        System.out.println(mainMapper.getPersons().size());
        assertTrue(mainMapper.getPersons().size() > 0);


        // Change these tests as the mappings are implemented
        System.out.println("Observations Count: ");
        System.out.println(mainMapper.getObservations().size());
        assertTrue(mainMapper.getObservations().size() == 0);

        System.out.println("Measurements Count: ");
        System.out.println(mainMapper.getMeasurements().size());
        assertTrue(mainMapper.getMeasurements().size() == 0);

        System.out.println("DrugExposure Count: ");
        System.out.println(mainMapper.getDrugExposures().size());
        assertTrue(mainMapper.getDrugExposures().size() == 0);

        System.out.println("VisitOccurrence Count: ");
        System.out.println(mainMapper.getVisitOccurrences().size());
        assertTrue(mainMapper.getVisitOccurrences().size() == 0);

        System.out.println("ProcedureOccurrence Count: ");
        System.out.println(mainMapper.getProcedureOccurrences().size());
        assertTrue(mainMapper.getProcedureOccurrences().size() == 0);
    }

    @Test
    void createBundle() {
    }
}