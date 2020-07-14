package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.ProcedureOccurrence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProcedureOccurrenceServiceTest {

    @Autowired
    CohortService cohortService;
    
    @Autowired
    ProcedureOccurrenceService procedureOccurrenceService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // @Test
    // void list() {
    //     List<ProcedureOccurrence> procedureOccurrences = procedureOccurrenceService.list();
    //     System.out.println(procedureOccurrences.size());
    //     assertTrue(procedureOccurrences.size() > 0);
    // }

    @Test
    void listByPerson() {
        List<ProcedureOccurrence> procedureOccurrences = procedureOccurrenceService.listByPerson(2);
        System.out.println(procedureOccurrences.size());
        assertTrue(procedureOccurrences.size() > 0);
    }

    @Test
    void listByCohorts() {
        List<Cohort> cohorts = cohortService.listByCohort(2);
        for (int i = 0; i < 10; i++) {
            // System.out.println(cohorts.get(i));
            Cohort cohort = cohorts.get(i);
            List<ProcedureOccurrence> procedureOccurrences = 
                procedureOccurrenceService.listByPersonAndPeriod(
                    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
            System.out.println(procedureOccurrences.size());
        }
        assertTrue(cohorts.size() > 0);
    }
}