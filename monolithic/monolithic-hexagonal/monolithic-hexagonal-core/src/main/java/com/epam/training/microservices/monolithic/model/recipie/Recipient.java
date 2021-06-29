package com.epam.training.microservices.monolithic.model.recipie;

import com.epam.training.microservices.monolithic.model.HasId;
import com.google.common.collect.Sets;
import java.util.Set;
import lombok.Data;

/**
 * 
 */
@Data
public class Recipient implements HasId<Long> {
    private Long id;

    /**
     * Recipient name, etc. 
     */
    private String firstName; 
    private String lastName; 

    /**
     * A collection of recipes associated with this recipient.
     */
    private Set<Recipe> recipes = Sets.newHashSet();
}
