package com.epam.training.microservices.monolithic.jpa.entity.disease;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Symptom of the particular disease. 
 */
@Data
@Entity
@Table(name = "symptoms")
public class SymptomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the symptom. 
     */
    private String name; 

    /**
     * Description of the symptom. 
     */
    private String description;
}
