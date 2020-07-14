package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.DrugExposure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DrugExposureServiceTest {

    @Autowired
    CohortService cohortService;
    
    @Autowired
    DrugExposureService drugExposureService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    // @Test
    // void list() {
    //     List<DrugExposure> drugExposures = drugExposureService.list();
    //     System.out.println(drugExposures.size());
    //     assertTrue(drugExposures.size() > 0);
    // }

    @Test
    void listByPerson() {
        List<DrugExposure> drugExposures = drugExposureService.listByPerson(2);
        System.out.println(drugExposures.size());
        assertTrue(drugExposures.size() > 0);
    }

    @Test
    void listByCohorts() {
        List<Cohort> cohorts = cohortService.listByCohort(2);
        for (int i = 0; i < 10; i++) {
            // System.out.println(cohorts.get(i));
            Cohort cohort = cohorts.get(i);
            List<DrugExposure> drugExposures = 
                drugExposureService.listByPersonAndPeriod(
                    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
            System.out.println(drugExposures.size());
        }
        assertTrue(cohorts.size() > 0);
    }
}