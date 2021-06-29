package com.epam.training.microservices.monolithic.model.disease;

import com.epam.training.microservices.monolithic.model.HasId;
import com.google.common.collect.Sets;
import java.util.Set;
import lombok.Data;

/**
 * Diseases. 
 */
@Data
public class Disease implements HasId<Long> {
    private Long id;

    /**
     * Name of the disease.
     */
    private String name; 

    /**
     * Description of the disease. 
     */
    private String description; 

    /**
     * A collection of symptoms related to the disease.
     */
    private Set<Symptom> symptoms = Sets.newHashSet();
}
