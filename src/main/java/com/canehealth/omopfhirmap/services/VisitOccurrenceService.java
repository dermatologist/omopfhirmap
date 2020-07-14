package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.VisitOccurrenceRepository;
import com.canehealth.omopfhirmap.models.VisitOccurrence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class VisitOccurrenceService {

    @Autowired
    private VisitOccurrenceRepository visitOccurrenceRepository;

    public List<VisitOccurrence> list(){
        return visitOccurrenceRepository.findAll();
    }

    public List<VisitOccurrence> listByPerson(Integer personId){
        return visitOccurrenceRepository.findByPersonId(personId);
    }

    public List<VisitOccurrence> listByPersonAndPeriod(Integer personId, Date start, Date end){
        return visitOccurrenceRepository.findByPersonIdAndVisitStartDateBetween(personId, start, end);
    }
    
}