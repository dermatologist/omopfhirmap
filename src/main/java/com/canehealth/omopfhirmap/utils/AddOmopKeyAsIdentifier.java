package com.canehealth.omopfhirmap.utils;

import com.canehealth.omopfhirmap.models.BaseModel;
import org.hl7.fhir.r4.model.Identifier;

public class AddOmopKeyAsIdentifier<M extends BaseModel> {

    public Identifier add(M omopResource, String myIdentifierSystem){
        Identifier identifier = new Identifier();
        identifier.setSystem(myIdentifierSystem);
        identifier.setValue(omopResource.getId().toString());
        return identifier;
    }


}
