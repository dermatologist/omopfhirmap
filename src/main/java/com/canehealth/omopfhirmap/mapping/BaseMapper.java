package com.canehealth.omopfhirmap.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.canehealth.omopfhirmap.fetchers.BaseFetcher;
import com.canehealth.omopfhirmap.fetchers.PersonFetcher;
import com.canehealth.omopfhirmap.fhir.R4Bundle;
import com.canehealth.omopfhirmap.models.Cohort;
import com.canehealth.omopfhirmap.models.Person;
import com.canehealth.omopfhirmap.services.CohortService;
import com.canehealth.omopfhirmap.services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class BaseMapper {

    @Autowired
    CohortService cohortService;

    @Autowired
    PersonFetcher personFetcher;

    private List<Cohort> cohorts = new ArrayList<>();
    private Cohort cohort;
    private R4Bundle r4Bundle;
    private int cohortId = 0;
    private int cohortSize = 0;
    private List<Person> persons = new ArrayList<>();

    public void fetchCohort() {
        if (this.cohortId > 0) {
            this.cohorts = this.cohortService.listByCohort(this.cohortId);
            this.cohortSize = this.cohorts.size();
        }
    }

    public void trimList(int ct){
        this.cohorts = this.cohorts.stream()
                .limit(ct)
                .collect(Collectors.toList());
    }

    public void fetchOmopResources() throws InterruptedException {
        personFetcher.setCohorts(this.cohorts);
        personFetcher.start();
        personFetcher.join();
        this.persons = personFetcher.getOmopResources();
    }

    public void createBundle(){
        
    }


}