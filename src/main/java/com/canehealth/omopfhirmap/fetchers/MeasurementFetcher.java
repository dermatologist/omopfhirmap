package com.canehealth.omopfhirmap.fetchers;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.Measurement;
import com.canehealth.omopfhirmap.services.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MeasurementFetcher extends BaseFetcher<Measurement>{

    @Autowired
    MeasurementService measurementService;

    @Override
    public void run() {
        for(Cohort cohort: this.cohorts){
            this.omopStep = this.measurementService.listByPersonAndPeriod(
                    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
            this.omopResources.addAll(this.omopStep);
        }
    }

}