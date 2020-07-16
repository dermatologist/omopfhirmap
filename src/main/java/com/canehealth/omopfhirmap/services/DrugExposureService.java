package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.DrugExposureRepository;
import com.canehealth.omopfhirmap.models.DrugExposure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class DrugExposureService implements BaseService<DrugExposureRepository, DrugExposure>{

    @Autowired
    private DrugExposureRepository drugExposureRepository;

    public List<DrugExposure> list(){
        return drugExposureRepository.findAll();
    }

    public List<DrugExposure> listByPerson(Integer personId){
        return drugExposureRepository.findByPersonId(personId);
    }

    public List<DrugExposure> listByPersonAndPeriod(Integer personId, Date start, Date end){
        return drugExposureRepository.findByPersonIdAndDrugExposureStartDateBetween(personId, start, end);
    }
    
}