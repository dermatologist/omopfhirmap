package com.canehealth.omopfhirmap.repositories;

import com.canehealth.omopfhirmap.models.Cohort;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CohortRepository extends JpaRepository<Cohort, Integer>{
    
}