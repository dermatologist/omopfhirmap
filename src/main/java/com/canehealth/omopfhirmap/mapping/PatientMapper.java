package com.canehealth.omopfhirmap.mapping;

import com.canehealth.omopfhirmap.models.Person;
import com.canehealth.omopfhirmap.services.PersonService;
import com.canehealth.omopfhirmap.utils.AddOmopKeyAsIdentifier;
import com.canehealth.omopfhirmap.utils.OmopConstants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hl7.fhir.r4.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class PatientMapper extends BaseMapper<Person, Patient>{

    @Value("${omopfhir.system.name}")
    private String myIdentifierSystem;

    @Autowired
    PersonService personService;

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

        // TODO: Map race and ethnicity.

        //  generalPractitioner		0..*	Reference(Organization | Practitioner | PractitionerRole)
        //  Patient's nominated primary care provider
        if(this.omopResource.getProviderId()!=null) {
            List<Reference> generalPractitioners = this.fhirResource.getGeneralPractitioner();
            Practitioner practitioner = new Practitioner();
            practitioner.setId(this.omopResource.getProviderId().toString());
            Reference reference = new Reference();
            reference.setResource(practitioner);
            generalPractitioners.add(reference);
            this.fhirResource.setGeneralPractitioner(generalPractitioners);
        }

        // managingOrganization	Σ	0..1	Reference(Organization)
        // Organization that is the custodian of the patient record
        if(this.omopResource.getLocationId()!=null) {
            Organization organization = new Organization();
            organization.setId(this.omopResource.getLocationId().toString());
            Reference reference = new Reference();
            reference.setResource(organization);
            this.fhirResource.setManagingOrganization(reference);
        }
    }

    public void mapFhirToOmop(){
            List<Identifier> identifiers = this.fhirResource.getIdentifier();
            for(Identifier identifier: identifiers){
                if(identifier.getSystem().equals(myIdentifierSystem)){
                    String myId = identifier.getValue();
                    Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
                    List<Person> persons = personService.listByPersonAndPeriod(Integer.parseInt(myId), today , today);
                    if(persons.isEmpty())
                        System.out.println("Does not exist");
                    else {
                        // Exists
                        this.omopResource = null;
                    }
                }
            }
    }
}