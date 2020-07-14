package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.models.Observation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ObservationServiceTest {

    @Autowired
    ObservationService observationService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void list() {
        List<Observation> observations = observationService.list();
        System.out.println(observations.size());
        assertTrue(observations.size() > 0);
    }

    @Test
    void listByPerson() {
        List<Observation> observations = observationService.listByPerson(2);
        System.out.println(observations.size());
        assertTrue(observations.size() > 0);
    }
}