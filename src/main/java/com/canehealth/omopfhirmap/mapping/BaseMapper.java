package com.canehealth.omopfhirmap.mapping;

import com.canehealth.omopfhirmap.fhir.R4Bundle;
import com.canehealth.omopfhirmap.models.Cohort;

import lombok.Data;

@Data
public class BaseMapper {
    
    private Cohort cohort;
    private R4Bundle r4Bundle;
}