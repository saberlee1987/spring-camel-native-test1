package com.saber.spring.camel.test1.dto;

import com.saber.spring.camel.test1.entities.PersonEntity;
import lombok.Data;
import java.util.List;
@Data
public class PersonResponse {
    private List<PersonEntity> persons ;
}
