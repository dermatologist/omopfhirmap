package com.canehealth.omopfhirmap.mapping;

import com.canehealth.omopfhirmap.models.Person;
import com.canehealth.omopfhirmap.services.PersonService;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Patient;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class PatientMapperTest {

    @Autowired
    PersonService personService;

    @Autowired
    PatientMapper patientMapper;

    @Value("${omopfhir.system.name}")
    private String myIdentifierSystem;

    private Patient patient;

    @BeforeEach
    void setUp() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("patient-example.json");
        //creating an InputStreamReader object
        assert inputStream != null;
        InputStreamReader isReader = new InputStreamReader(inputStream);
        //Creating a BufferedReader object
        BufferedReader reader = new BufferedReader(isReader);
        StringBuilder sb = new StringBuilder();
        String str;
        try {
			while((str = reader.readLine())!= null){
			    sb.append(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        }
        //System.out.print(sb.toString());
        patient = patientMapper.parseResourceFromJsonString(sb.toString());
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void mapOmopToFhirTest() {
        Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        List<Person> persons = personService.listByPersonAndPeriod(2, today , today);
        Person person = persons.get(0);
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
    void mapFhirToOmopTest() {
        List<Identifier> identifiers = patientMapper.fhirResource.getIdentifier();
        for(Identifier identifier: identifiers) {
            if (identifier.getSystem().equals(myIdentifierSystem))
                identifier.setValue("73452435"); // Unknown value
        }
       patientMapper.mapFhirToOmop();
       System.out.println(patientMapper.omopResource.getPersonSourceValue());
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