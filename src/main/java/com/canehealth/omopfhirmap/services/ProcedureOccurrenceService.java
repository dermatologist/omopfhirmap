package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.ProcedureOccurrenceRepository;
import com.canehealth.omopfhirmap.models.ProcedureOccurrence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class ProcedureOccurrenceService implements BaseService<ProcedureOccurrenceRepository, ProcedureOccurrence> {

    @Autowired
    private ProcedureOccurrenceRepository procedureOccurrenceRepository;

    public List<ProcedureOccurrence> list(){
        return procedureOccurrenceRepository.findAll();
    }

    public List<ProcedureOccurrence> listByPerson(Integer personId){
        return procedureOccurrenceRepository.findByPersonId(personId);
    }

    public List<ProcedureOccurrence> listByPersonAndPeriod(Integer personId, Date start, Date end){
        return procedureOccurrenceRepository.findByPersonIdAndProcedureDateBetween(personId, start, end);
    }
    
}