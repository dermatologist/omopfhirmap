package com.canehealth.omopfhirmap.repositories;

import com.canehealth.omopfhirmap.models.VisitOccurrence;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

@Repository
public interface VisitOccurrenceRepository extends JpaRepository<VisitOccurrence, Integer>{

    List<VisitOccurrence> findByPersonId(Integer personId);
    List<VisitOccurrence> findByPersonIdAndVisitStartDateBetween(Integer personId, Date start, Date end);
    
}