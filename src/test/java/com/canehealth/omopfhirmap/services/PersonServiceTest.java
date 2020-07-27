package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.models.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonServiceTest {

    @Autowired
    PersonService personService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void list() {
        List<Person> persons = personService.list();
        System.out.println(persons.size());
        assertTrue(persons.size() > 0);
    }

    @Test
    void listByPerson() {
        Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        List<Person> persons = personService.listByPersonAndPeriod(42, today , today);
        System.out.println(persons.size());
        assertTrue(persons.size() > 0);
    }
}