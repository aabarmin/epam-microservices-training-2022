package com.epam.training.microservice.service.recipes.model;

import lombok.Data;

import javax.persistence.*;

/**
 * An entity to store information about doctors who issue the recipiees. 
 */
@Data
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Doctor's name. 
     */
    private String firstName; 
    private String lastName;

}
