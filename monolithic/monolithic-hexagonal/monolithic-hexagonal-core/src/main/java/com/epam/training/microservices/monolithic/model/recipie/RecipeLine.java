package com.epam.training.microservices.monolithic.model.recipie;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * One line of the recipe.
 */
@Data
@EqualsAndHashCode(exclude = {
    "drug",
    "recipe"
})
public class RecipeLine {
    private Long id;

    private Recipe recipe;

    /**
     * A drug to apply. 
     */
    private Drug drug;

    /**
     * Amount of drug to apply. 
     */
    private Long amount; 

    /**
     * What exactly to be done. 
     */
    private String instruction;
}
