package com.canehealth.omopfhirmap.mapping;

import com.canehealth.omopfhirmap.models.BaseModel;
import org.hl7.fhir.r4.model.Resource;

public interface IBaseMapper<M extends BaseModel, F extends Resource> {

    F mapOmopToFhir();
    M mapFhirToOmop();
}
