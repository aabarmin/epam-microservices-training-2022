package com.epam.training.microservice.service.recipes.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A recipie to apply. 
 */
@Data
@Entity
@Table(name = "recipes")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * A doctor who issues the recipie.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Doctor doctor;

    /**
     * A recipient of the recipie. 
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Recipient recipient;

    /**
     * A content of the recipie. 
     */
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<RecipeLine> lines = new HashSet<>();

    /**
     * Issue date of the recipe.
     */
    private LocalDate issueDate;
}
