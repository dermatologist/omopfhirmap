package com.canehealth.omopfhirmap.fetchers;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.Observation;
import com.canehealth.omopfhirmap.services.ObservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ObservationFetcher extends BaseFetcher<Observation>{

    @Autowired
    ObservationService observationService;

    @Override
    public void run() {
        for(Cohort cohort: this.cohorts){
            this.omopStep = this.observationService.listByPersonAndPeriod(
                    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
            this.omopResources.addAll(this.omopStep);
        }
    }

}