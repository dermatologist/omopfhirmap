package com.canehealth.omopfhirmap.mapping;

import java.util.List;

import com.canehealth.omopfhirmap.fhir.R4Bundle;
import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.services.CohortService;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BaseMapper {

    @Autowired
    CohortService cohortService;
    
    private List<Cohort> cohorts;
    private Cohort cohort;
    private R4Bundle r4Bundle;
    private int cohortId = 0;
    private int cohortSize = 0;

    public void fetchCohort(){
        if(this.cohortId>0){
            this.cohorts = this.cohortService.listByCohort(this.cohortId);
            this.cohortSize = this.cohorts.size();
        }
    }

    public void fetchOmopResources(){

    }

    public void createBundle(){
        
    }


}