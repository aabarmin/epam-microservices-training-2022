package com.epam.training.microservices.monolithic.model.disease;

import com.epam.training.microservices.monolithic.model.HasId;
import lombok.Data;

/**
 * Symptom of the particular disease. 
 */
@Data
public class Symptom implements HasId<Long> {
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
