package com.canehealth.omopfhirmap.mapping;

import org.junit.jupiter.api.AfterEach;
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

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void fetchCohort() {
        baseMapper.setCohortId(2);
        baseMapper.fetchCohort();
        System.out.println(baseMapper.getCohortSize());
        assertTrue(baseMapper.getCohortSize() > 0);
    }

    @Test
    void fetchOmopResources() {
    }

    @Test
    void createBundle() {
    }
}