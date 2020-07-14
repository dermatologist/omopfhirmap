package com.canehealth.omopfhirmap.services;

import com.canehealth.omopfhirmap.repositories.PersonRepository;
import com.canehealth.omopfhirmap.models.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> list(){
        return personRepository.findAll();
    }

    public List<Person> listByPerson(Integer personId){
        return personRepository.findByPersonId(personId);
    }
    
}