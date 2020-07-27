package com.canehealth.omopfhirmap.fetchers;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.DrugExposure;
import com.canehealth.omopfhirmap.services.DrugExposureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrugExposureFetcher extends BaseFetcher<DrugExposure>{

    @Autowired
    DrugExposureService drugExposureService;

    @Override
    public void run() {
        for(Cohort cohort: this.cohorts){
            this.omopStep = this.drugExposureService.listByPersonAndPeriod(
                    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
            this.omopResources.addAll(this.omopStep);
        }
    }

}