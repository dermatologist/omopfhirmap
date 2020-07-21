package com.canehealth.omopfhirmap.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import com.canehealth.omopfhirmap.fetchers.*;
import com.canehealth.omopfhirmap.models.*;
import com.canehealth.omopfhirmap.services.CohortService;
import com.canehealth.omopfhirmap.services.PersonService;
import com.canehealth.omopfhirmap.utils.BundleProcessor;
import com.canehealth.omopfhirmap.utils.BundleRunnable;
import com.canehealth.omopfhirmap.utils.OmopProcessor;

import org.hl7.fhir.r4.model.Bundle;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.Data;
import org.springframework.stereotype.Component;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.parser.IParser;

@Component
@Data
public class MainMapper {

    @Autowired
    CohortService cohortService;

    @Autowired
    PersonService personService;

    @Autowired
    PersonFetcher personFetcher;

    @Autowired 
    PatientMapper patientMapper;

    @Autowired
    ObservationFetcher observationFetcher;

    @Autowired
    MeasurementFetcher measurementFetcher;

    @Autowired
    DrugExposureFetcher drugExposureFetcher;

    @Autowired
    VisitOccurrenceFetcher visitOccurrenceFetcher;

    @Autowired
    ProcedureOccurrenceFetcher procedureOccurrenceFetcher;

    @Autowired
    BundleProcessor bundleProcessor;

    private List<Cohort> cohorts = new ArrayList<>();
    private Cohort cohort;
    private int cohortId = 0;
    private int cohortSize = 0;
    private List<Person> persons = new ArrayList<>();
    private List<Observation> observations = new ArrayList<>();
    private List<Measurement> measurements = new ArrayList<>();
    private List<DrugExposure> drugExposures = new ArrayList<>();
    private List<VisitOccurrence> visitOccurrences = new ArrayList<>();
    private List<ProcedureOccurrence> procedureOccurrences = new ArrayList<>();

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
        
        // @TODO uncomment along with implementations

        // observationFetcher.setCohorts(this.cohorts);
        // observationFetcher.start();

        // measurementFetcher.setCohorts(this.cohorts);
        // measurementFetcher.start();

        // drugExposureFetcher.setCohorts(this.cohorts);
        // drugExposureFetcher.start();

        // visitOccurrenceFetcher.setCohorts(this.cohorts);
        // visitOccurrenceFetcher.start();

        // procedureOccurrenceFetcher.setCohorts(this.cohorts);
        // procedureOccurrenceFetcher.start();


        // visitOccurrenceFetcher.join();
        // procedureOccurrenceFetcher.join();
        // drugExposureFetcher.join();
        // measurementFetcher.join();
        // observationFetcher.join();
        personFetcher.join();
        
        this.persons = personFetcher.getOmopResources();
        // this.observations = observationFetcher.getOmopResources();
        // this.measurements = measurementFetcher.getOmopResources();
        // this.drugExposures = drugExposureFetcher.getOmopResources();
        // this.visitOccurrences = visitOccurrenceFetcher.getOmopResources();
        // this.procedureOccurrences = procedureOccurrenceFetcher.getOmopResources();
    }

    public void createBundle() throws InterruptedException {
        fetchCohort();
        //TODO remove
        trimList(50);
        fetchOmopResources();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(Person person: persons){
            System.out.println("Processing:" + person.getId().toString());
            // patientMapper instance should not be shared by the threads, hence new
            BundleRunnable<Person, PatientMapper> myRunnable = new BundleRunnable<>(person, new PatientMapper(), bundleProcessor);
            executor.execute(myRunnable);
        }
        executor.shutdown();
    }

    public void writeOmop(String fhirBundleAsString, int cohortId){
        BundleProcessor.parseBundleFromJsonString(fhirBundleAsString);
        List<Bundle.BundleEntryComponent> fhirResources = BundleProcessor.bundle.getEntry();
        
        for(Bundle.BundleEntryComponent fhirEntry : fhirResources){
            Resource fhirResource = fhirEntry.getResource();
            System.out.println("Processing:" + fhirResource.fhirType());
            //if(fhirResource.get)
            if(fhirResource.fhirType().equals("Patient")){
                OmopProcessor<Person, PersonService> omopProcessor = new OmopProcessor<>();
                patientMapper.setFhirResource((Patient)fhirResource);
                Person person = patientMapper.mapFhirToOmop();
                if(person != null)
                    omopProcessor.add(person, personService, cohortService, cohortId);
            }
        }
    }

}