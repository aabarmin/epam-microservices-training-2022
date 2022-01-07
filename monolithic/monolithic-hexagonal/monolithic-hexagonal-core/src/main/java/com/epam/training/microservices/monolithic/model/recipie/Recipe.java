package com.epam.training.microservices.monolithic.model.recipie;

import com.epam.training.microservices.monolithic.model.HasId;
import com.google.common.collect.Sets;
import java.time.LocalDate;
import java.util.Set;
import lombok.Data;

/**
 * A recipe to apply.
 */
@Data
public class Recipe implements HasId<Long> {
    private Long id;

    /**
     * A doctor who issues the recipe.
     */
    private Doctor doctor;

    /**
     * A recipient of the recipe.
     */
    private Recipient recipient;

    /**
     * A content of the recipe.
     */
    private Set<RecipeLine> lines = Sets.newHashSet();

    /**
     * Issue date of the recipe.
     */
    private LocalDate issueDate;
}
