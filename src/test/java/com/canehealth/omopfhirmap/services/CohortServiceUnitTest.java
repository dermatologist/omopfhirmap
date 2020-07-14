package com.canehealth.omopfhirmap.servives.tests;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.services.CohortService;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CohortServiceUnitTest {

    @Autowired
    private CohortService cohortService;

    @Test
    public void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
        List<Cohort> cohorts = cohortService.list();

        Assert.assertEquals(cohorts.size(), 3);
    }
}