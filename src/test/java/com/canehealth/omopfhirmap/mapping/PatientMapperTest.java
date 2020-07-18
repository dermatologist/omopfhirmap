package com.canehealth.omopfhirmap.mapping;

import com.canehealth.omopfhirmap.fhir.R4Patient;
import com.canehealth.omopfhirmap.models.Person;
import com.canehealth.omopfhirmap.services.PersonService;
import org.hl7.fhir.r4.model.Identifier;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientMapperTest {

    @Autowired
    PersonService personService;

    @Autowired
    PatientMapper patientMapper;

    @Value("${omopfhir.system.name}")
    private String myIdentifierSystem;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mapOmopToFhirIdentifier() {
        Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        List<Person> persons = personService.listByPersonAndPeriod(2, today , today);
        Person person = persons.get(0);
        R4Patient patient = new R4Patient();
        patientMapper.setOmopResource(person);
        patientMapper.setFhirResource(patient);
        patientMapper.mapOmopToFhir();
        List<Identifier> identifiers = patientMapper.fhirResource.getIdentifier();
        for(Identifier identifier: identifiers) {
            System.out.println(identifier.getSystem());
            if(identifier.getSystem().equals(myIdentifierSystem))
                assertEquals(identifier.getValue(), person.getPersonId().toString());
        }
        System.out.print(patientMapper.encodeResourceToJsonString());
    }

    @Test
    void testEquals() {
    }

    @Test
    void canEqual() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}