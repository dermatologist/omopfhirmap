package com.canehealth.omopfhirmap.fetchers;

import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.ProcedureOccurrence;
import com.canehealth.omopfhirmap.services.ProcedureOccurrenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProcedureOccurrenceFetcher extends BaseFetcher<ProcedureOccurrence>{

    @Autowired
    ProcedureOccurrenceService procedureOccurrenceService;

    @Override
    public void run() {
        for(Cohort cohort: this.cohorts){
            this.omopStep = this.procedureOccurrenceService.listByPersonAndPeriod(
                    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
            this.omopResources.addAll(this.omopStep);
        }
    }

}