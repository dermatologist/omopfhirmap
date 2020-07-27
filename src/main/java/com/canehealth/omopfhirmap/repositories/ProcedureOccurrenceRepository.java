package com.canehealth.omopfhirmap.repositories;

import com.canehealth.omopfhirmap.models.ProcedureOccurrence;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

@Repository
public interface ProcedureOccurrenceRepository extends JpaRepository<ProcedureOccurrence, Integer>{

    List<ProcedureOccurrence> findByPersonId(Integer personId);
    List<ProcedureOccurrence> findByPersonIdAndProcedureDateBetween(Integer personId, Date start, Date end);
    
}