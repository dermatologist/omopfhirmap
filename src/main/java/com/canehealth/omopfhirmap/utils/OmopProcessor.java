package com.canehealth.omopfhirmap.utils;

import com.canehealth.omopfhirmap.models.BaseModel;
import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.services.BaseService;
import com.canehealth.omopfhirmap.services.CohortService;

import java.sql.Date;
import java.util.Calendar;

public class OmopProcessor<O extends BaseModel, S extends BaseService> {

    public void add(O omopResource, S service, CohortService cohortService, int cohortId){
        if(omopResource.getClass().getSimpleName().equals("Person")){
            // Save resource first to get the autoincrement ID
            service.save(omopResource);
            Cohort cohort = new Cohort();
            cohort.setCohortDefinitionId(cohortId);
            cohort.setSubjectId(omopResource.getId()); // Get the newly assigned ID.
            Date today = new java.sql.Date(Calendar.getInstance().getTime().getTime());
            cohort.setCohortStartDate(today);
            cohort.setCohortEndDate(today);
            cohortService.save(cohort);
        }else{
            service.save(omopResource);
        }

    }
}
