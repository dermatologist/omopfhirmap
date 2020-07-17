package com.canehealth.omopfhirmap.utils;

import com.canehealth.omopfhirmap.fhir.R4Patient;
import com.canehealth.omopfhirmap.models.BaseModel;
import lombok.Data;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.ResourceType;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.Entity;

@Data
public class AddOmopKeyAsIdentifier<M extends BaseModel, F extends Resource> {

    public M omopResource;
    public F fhirResource;

    @Value("${omopfhir.system.name}")
    private String myIdentifierSystem;

    public F add(M omopResource, F fhirResource){
        Identifier identifier = new Identifier();
        identifier.setSystem(myIdentifierSystem);
        identifier.setValue(omopResource.getId().toString());
        if(this.fhirResource.getResourceType() == ResourceType.Patient){
            R4Patient patient = (R4Patient) this.fhirResource;
            patient.addIdentifier(identifier);
            this.fhirResource = (F) patient;
            return (F) patient;
        }
        return (F) fhirResource;
    }


}
