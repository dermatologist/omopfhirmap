package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.CohortRepository;
import com.canehealth.omopfhirmap.models.Cohort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CohortService {

    @Autowired
    private CohortRepository cohortRepository;

    public List<Cohort> list(){
        return cohortRepository.findAll();
    }

    public List<Cohort> listByCohort(Integer cohortDefinitionId){
        return cohortRepository.findByCohortDefinitionId(cohortDefinitionId);
    }
    
}