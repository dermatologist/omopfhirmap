package com.canehealth.omopfhirmap.mapping;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.canehealth.omopfhirmap.services.BaseService;
import com.canehealth.omopfhirmap.models.Cohort;

import lombok.Data;

@Data
public class BaseFetcher<S extends BaseService<?, M>, M> {

    private List<Cohort> cohorts;
    private List<M> omopResources;

    private final Class<S> OmopService;

    // @IMPORTANT: This constructor is required for generics
    public BaseFetcher(Class<S> OmopService) {
        this.OmopService = OmopService;
    }

    public void run() throws InstantiationException, IllegalAccessException, IllegalArgumentException,
            InvocationTargetException, NoSuchMethodException, SecurityException {
        for(Cohort cohort: cohorts){
            // @IMPORTANT: See how the instance is created
            List<M> omopTemp = this.OmopService.getDeclaredConstructor().newInstance().listByPersonAndPeriod(
                cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());

            omopResources.addAll(omopTemp);
        }
    }
    
}