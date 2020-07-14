package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.VisitOccurrence;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VisitOccurrenceServiceTest {

    @Autowired
    CohortService cohortService;
    
    @Autowired
    VisitOccurrenceService visitOccurrenceService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // @Test
    // void list() {
    //     List<VisitOccurrence> visitOccurrences = visitOccurrenceService.list();
    //     System.out.println(visitOccurrences.size());
    //     assertTrue(visitOccurrences.size() > 0);
    // }

    @Test
    void listByPerson() {
        List<VisitOccurrence> visitOccurrences = visitOccurrenceService.listByPerson(2);
        System.out.println(visitOccurrences.size());
        assertTrue(visitOccurrences.size() > 0);
    }

    @Test
    void listByCohorts() {
        List<Cohort> cohorts = cohortService.listByCohort(2);
        for (int i = 0; i < 10; i++) {
            // System.out.println(cohorts.get(i));
            Cohort cohort = cohorts.get(i);
            List<VisitOccurrence> visitOccurrences = 
                visitOccurrenceService.listByPersonAndPeriod(
                    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
            System.out.println(visitOccurrences.size());
        }
        assertTrue(cohorts.size() > 0);
    }
}