package com.canehealth.omopfhirmap.services;

import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService <j extends JpaRepository<?, Integer>>{
    
    
    public abstract List<j> list();

    public abstract List<j> listByPerson(Integer personId);

    public abstract List<j> listByPersonAndPeriod(Integer personId, Date start, Date end);
    
}