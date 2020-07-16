package com.canehealth.omopfhirmap.fetchers;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.VisitOccurrence;
import com.canehealth.omopfhirmap.services.VisitOccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VisitOccurrenceFetcher extends BaseFetcher<VisitOccurrence>{

    @Autowired
    VisitOccurrenceService visitOccurrenceService;

    @Override
    public void run() {
        for(Cohort cohort: this.cohorts){
            this.omopStep = this.visitOccurrenceService.listByPersonAndPeriod(
                    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
            this.omopResources.addAll(this.omopStep);
        }
    }

}