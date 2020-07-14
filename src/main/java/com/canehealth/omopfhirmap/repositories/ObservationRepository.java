package com.canehealth.omopfhirmap.repositories;

import com.canehealth.omopfhirmap.models.Observation;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ObservationRepository extends JpaRepository<Observation, Integer>{

    List<Observation> findByPersonId(Integer personId);
    
}