package com.canehealth.omopfhirmap.services;
import com.canehealth.omopfhirmap.models.BaseModel;

import java.util.List;
import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseService <J extends JpaRepository<?, Integer>, C extends BaseModel>{
    
    
    List<C> list();

    List<C> listByPerson(Integer personId);

    List<C> listByPersonAndPeriod(Integer personId, Date start, Date end);

    void save(C model);
}