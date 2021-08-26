package com.saber.spring.camel.test1.services.impl;

import com.saber.spring.camel.test1.dto.PersonDto;
import com.saber.spring.camel.test1.dto.PersonResponse;
import com.saber.spring.camel.test1.entities.PersonEntity;
import com.saber.spring.camel.test1.exception.ResourceDuplicationException;
import com.saber.spring.camel.test1.exception.ResourceNotFoundException;
import com.saber.spring.camel.test1.repositories.PersonRepository;
import com.saber.spring.camel.test1.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    @Transactional
    public PersonEntity savePerson(PersonDto personDto) {
        if (this.personRepository.findByNationalCode(personDto.getNationalCode()).isPresent()){
            throw new ResourceDuplicationException(String.format("person with nationalCode %s exist",personDto.getNationalCode()));
        }
        PersonEntity entity = new PersonEntity();
        entity.setFirstName(personDto.getFirstName());
        entity.setLastName(personDto.getLastName());
        entity.setAge(personDto.getAge());
        entity.setMobile(personDto.getMobile());
        entity.setNationalCode(personDto.getNationalCode());

        return personRepository.save(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public PersonEntity findByNationalCode(String nationalCode) {
        Optional<PersonEntity> optionalPersonEntity= this.personRepository.findByNationalCode(nationalCode);
        if (optionalPersonEntity.isEmpty()){
            throw new ResourceNotFoundException(String.format("person with nationalCode %s does not found", nationalCode));
        }
        return optionalPersonEntity.get();
    }

    @Override
    @Transactional(readOnly = true)
    public PersonEntity findById(Integer id) {
        Optional<PersonEntity> optionalPersonEntity = this.personRepository.findById(id);
        if (optionalPersonEntity.isEmpty()){
            throw new ResourceNotFoundException(String.format("person with id %d does not found", id));
        }
        return optionalPersonEntity.get();
    }

    @Override
    @Transactional(readOnly = true)
    public PersonResponse findAll() {
        PersonResponse response = new PersonResponse();
        response.setPersons(this.personRepository.findAll());
        return response;
    }
}
