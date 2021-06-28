package com.epam.training.microservices.monolithic.model.recipie;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
