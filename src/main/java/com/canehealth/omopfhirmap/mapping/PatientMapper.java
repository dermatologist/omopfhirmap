package com.canehealth.omopfhirmap.mapping;

import com.canehealth.omopfhirmap.models.*;
import com.canehealth.omopfhirmap.fhir.*;
import com.canehealth.omopfhirmap.utils.AddOmopKeyAsIdentifier;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hl7.fhir.r4.model.Identifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Component
public class PatientMapper extends BaseMapper<Person, R4Patient>{

    @Value("${omopfhir.system.name}")
    private String myIdentifierSystem;

    public void mapOmopToFhir(){
//        Identifier identifier = new Identifier();
//        identifier.setSystem(myIdentifierSystem);
//        identifier.setValue(this.omopResource.getPersonId().toString());
//        this.fhirResource.addIdentifier(identifier);

        AddOmopKeyAsIdentifier<Person, R4Patient> addOmopKeyAsIdentifier = new AddOmopKeyAsIdentifier<Person, R4Patient>();
        this.fhirResource = addOmopKeyAsIdentifier.add(this.omopResource, this.fhirResource);

    }
}