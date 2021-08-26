package com.saber.spring.camel.test1.repositories;

import com.saber.spring.camel.test1.entities.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<PersonEntity,Integer> {

    Optional<PersonEntity> findByNationalCode(String nationalCode);
}
