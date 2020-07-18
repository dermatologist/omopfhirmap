package com.canehealth.omopfhirmap.mapping;

import com.canehealth.omopfhirmap.fhir.R4Patient;
import com.canehealth.omopfhirmap.models.Person;
import com.canehealth.omopfhirmap.utils.AddOmopKeyAsIdentifier;
import com.canehealth.omopfhirmap.utils.OmopConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hl7.fhir.r4.model.Enumerations;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class PatientMapper extends BaseMapper<Person, R4Patient>{

    @Value("${omopfhir.system.name}")
    private String myIdentifierSystem;

    public void mapOmopToFhir(){
        AddOmopKeyAsIdentifier<Person> addOmopKeyAsIdentifier = new AddOmopKeyAsIdentifier<>();
        this.fhirResource.addIdentifier(addOmopKeyAsIdentifier.add(this.omopResource, myIdentifierSystem));

        // gender	Σ	0..1	code	male | female | other | unknown
        if(this.omopResource.getGenderConceptId().equals(OmopConstants.OMOP_FEMALE))
            this.fhirResource.setGender(Enumerations.AdministrativeGender.FEMALE);
        else if (this.omopResource.getGenderConceptId().equals(OmopConstants.OMOP_MALE))
            this.fhirResource.setGender(Enumerations.AdministrativeGender.MALE);
        else
            this.fhirResource.setGender(Enumerations.AdministrativeGender.UNKNOWN);

        // birthDate	Σ	0..1	date	The date of birth for the individual
        Calendar calendar = Calendar.getInstance();
        int yob, mob, dob;
        if (this.omopResource.getYearOfBirth() != null)
            yob = this.omopResource.getYearOfBirth();
        else
            yob = 1;
        if (this.omopResource.getMonthOfBirth() != null)
            mob = this.omopResource.getMonthOfBirth();
        else
            mob = 1;
        if (this.omopResource.getDayOfBirth() != null)
            dob = this.omopResource.getDayOfBirth();
        else
            dob = 1;
        calendar.set(yob, mob - 1, dob);
        this.fhirResource.setBirthDate(calendar.getTime());
    }
}