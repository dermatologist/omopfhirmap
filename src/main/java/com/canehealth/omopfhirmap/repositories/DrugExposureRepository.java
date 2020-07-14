package com.canehealth.omopfhirmap.repositories;

import com.canehealth.omopfhirmap.models.DrugExposure;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

@Repository
public interface DrugExposureRepository extends JpaRepository<DrugExposure, Integer>{

    List<DrugExposure> findByPersonId(Integer personId);
    List<DrugExposure> findByPersonIdAndDrugExposureStartDateBetween(Integer personId, Date start, Date end);
    
}