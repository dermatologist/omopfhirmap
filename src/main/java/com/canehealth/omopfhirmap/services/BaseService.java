package com.canehealth.omopfhirmap.services;

import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService <j extends JpaRepository<?, Integer>, c>{
    
    
    public abstract List<c> list();

    public abstract List<c> listByPerson(Integer personId);

    public abstract List<c> listByPersonAndPeriod(Integer personId, Date start, Date end);
    
}