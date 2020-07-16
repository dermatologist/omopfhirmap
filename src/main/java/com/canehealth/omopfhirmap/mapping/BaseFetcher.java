package com.canehealth.omopfhirmap.mapping;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.ArrayList;

import com.canehealth.omopfhirmap.services.BaseService;
import com.canehealth.omopfhirmap.models.Cohort;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class BaseFetcher<S extends BaseService<?, M>, M> {

    private List<Cohort> cohorts;
    private List<M> omopResources;

    private final Class<S> OmopService;

    @Autowired
    OmopService omopService;

    // @IMPORTANT: This constructor is required for generics
    public BaseFetcher(Class<S> OmopService) {
        this.OmopService = OmopService;
    }

    public void fetch() {
       for(Cohort cohort: this.cohorts){
            // @IMPORTANT: See how the instance is created
            List<M> omopTemp = new ArrayList<M>();
			try {
				omopTemp = this.OmopService.getDeclaredConstructor().newInstance().listByPersonAndPeriod(
				    cohort.getSubjectId(), cohort.getCohortStartDate(), cohort.getCohortEndDate());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            omopResources.addAll(omopTemp);
        }
    }
    
}