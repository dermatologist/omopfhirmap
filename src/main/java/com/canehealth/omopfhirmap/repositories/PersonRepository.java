package com.canehealth.omopfhirmap.repositories;

import com.canehealth.omopfhirmap.models.Person;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

    List<Person> findByPersonId(Integer personId);
    
}