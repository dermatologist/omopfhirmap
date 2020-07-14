package com.canehealth.omopfhirmap.repositories;

import com.canehealth.omopfhirmap.models.Measurement;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Integer>{

    List<Measurement> findByPersonId(Integer personId);
    
}