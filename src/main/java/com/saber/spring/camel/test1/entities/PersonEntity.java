package com.saber.spring.camel.test1.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "persons",uniqueConstraints = @UniqueConstraint(name = "nationalCodeUnique",columnNames = {"nationalCode"}))
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstName",length = 70)
    private String firstName;
    @Column(name = "lastName",length = 85)
    private String lastName;
    @Column(name = "nationalCode",length = 10,unique = true)
    private  String nationalCode;
    private Integer age;
    @Column(name = "mobile",length = 11)
    private String mobile;

}
