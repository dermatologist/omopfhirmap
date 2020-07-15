package com.canehealth.omopfhirmap.services;

import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class BaseService <J extends JpaRepository<?, Integer>, C>{
    
    
    public abstract List<C> list();

    public abstract List<C> listByPerson(Integer personId);

    public abstract List<C> listByPersonAndPeriod(Integer personId, Date start, Date end);
    
}