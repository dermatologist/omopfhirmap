package com.canehealth.omopfhirmap.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.canehealth.omopfhirmap.fetchers.*;
import com.canehealth.omopfhirmap.fhir.R4Bundle;
import com.canehealth.omopfhirmap.models.*;
import com.canehealth.omopfhirmap.services.CohortService;
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

    @Autowired
    ObservationFetcher observationFetcher;

    @Autowired
    MeasurementFetcher measurementFetcher;

    @Autowired
    DrugExposureFetcher drugExposureFetcher;

    private List<Cohort> cohorts = new ArrayList<>();
    private Cohort cohort;
    private R4Bundle r4Bundle;
    private int cohortId = 0;
    private int cohortSize = 0;
    private List<Person> persons = new ArrayList<>();
    private List<Observation> observations = new ArrayList<>();
    private List<Measurement> measurements = new ArrayList<>();
    private List<DrugExposure> drugExposures = new ArrayList<>();

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
        
        observationFetcher.setCohorts(this.cohorts);
        observationFetcher.start();

        measurementFetcher.setCohorts(this.cohorts);
        measurementFetcher.start();

        drugExposureFetcher.setCohorts(this.cohorts);
        drugExposureFetcher.start();

        drugExposureFetcher.join();
        measurementFetcher.join();
        observationFetcher.join();
        personFetcher.join();
        
        this.persons = personFetcher.getOmopResources();
        this.observations = observationFetcher.getOmopResources();
        this.measurements = measurementFetcher.getOmopResources();
        this.drugExposures = drugExposureFetcher.getOmopResources();
    }

    public void createBundle(){
        
    }


}