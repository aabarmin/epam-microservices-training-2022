package com.epam.training.microservices.monolithic.model.recipie;

import com.google.common.collect.Sets;
import java.time.LocalDate;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

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
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<RecipeLine> lines = Sets.newHashSet();

    /**
     * Issue date of the recipe.
     */
    private LocalDate issueDate;
}
