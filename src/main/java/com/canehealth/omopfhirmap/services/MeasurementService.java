package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.MeasurementRepository;
import com.canehealth.omopfhirmap.models.Measurement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepository measurementRepository;

    public List<Measurement> list(){
        return measurementRepository.findAll();
    }

    public List<Measurement> listByPerson(Integer personId){
        return measurementRepository.findByPersonId(personId);
    }
    
}