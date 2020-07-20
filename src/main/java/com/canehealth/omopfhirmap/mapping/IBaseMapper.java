package com.canehealth.omopfhirmap.mapping;

import com.canehealth.omopfhirmap.models.BaseModel;
import org.hl7.fhir.r4.model.Resource;

public interface IBaseMapper<F extends Resource, M extends BaseModel> {

    F mapOmopToFhir();
    M mapFhirToOmop();
}
