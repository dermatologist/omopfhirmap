package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.models.Cohort;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CohortServiceTest {

    @Autowired
    CohortService cohortService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void list() {
        List<Cohort> cohorts = cohortService.list();
        System.out.println(cohorts.size());
        assertTrue(cohorts.size() > 0);
    }

    @Test
    void listByCohorts() {
        List<Cohort> cohorts = cohortService.listByCohort(2);
        System.out.println(cohorts.size());
        assertTrue(cohorts.size() > 0);
    }
}