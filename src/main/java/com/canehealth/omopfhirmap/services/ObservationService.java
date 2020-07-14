package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.ObservationRepository;
import com.canehealth.omopfhirmap.models.Observation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservationService {

    @Autowired
    private ObservationRepository observationRepository;

    public List<Observation> list(){
        return observationRepository.findAll();
    }

    public List<Observation> listByPerson(Integer personId){
        return observationRepository.findByPersonId(personId);
    }

    public List<Observation> listByPersonAndPeriod(Integer personId, String start, String end){
        return observationRepository.findByPersonIdAndObservationDateBetween(personId, start, end);
    }
    
}