package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.PersonRepository;
import com.canehealth.omopfhirmap.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.sql.Date;
@Service
public class PersonService extends BaseService<PersonRepository, Person>{

    @Autowired
    private PersonRepository personRepository;

    public List<Person> list(){
        return personRepository.findAll();
    }

    public List<Person> listByPerson(Integer personId){
        return personRepository.findByPersonId(personId);
    }
    
    public List<Person> listByPersonAndPeriod(Integer personId, Date start, Date end){
        return personRepository.findByPersonId(personId);
    }
}