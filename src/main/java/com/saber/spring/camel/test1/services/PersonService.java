package com.saber.spring.camel.test1.services;

import com.saber.spring.camel.test1.dto.PersonDto;
import com.saber.spring.camel.test1.dto.PersonResponse;
import com.saber.spring.camel.test1.entities.PersonEntity;

public interface PersonService {
    PersonEntity savePerson(PersonDto personDto);
    PersonEntity findByNationalCode(String nationalCode);
    PersonEntity findById(Integer id);
    PersonResponse findAll();
}
