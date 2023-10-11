package com.epam.training.microservices.monolithic.model.recipie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

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
