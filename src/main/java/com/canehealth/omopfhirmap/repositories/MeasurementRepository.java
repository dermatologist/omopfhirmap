package com.canehealth.omopfhirmap.repositories;

import com.canehealth.omopfhirmap.models.Measurement;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer>{

    List<Measurement> findByPersonId(Integer personId);
    List<Measurement> findByPersonIdAndMeasurementDateBetween(Integer personId, Date start, Date end);

    
}