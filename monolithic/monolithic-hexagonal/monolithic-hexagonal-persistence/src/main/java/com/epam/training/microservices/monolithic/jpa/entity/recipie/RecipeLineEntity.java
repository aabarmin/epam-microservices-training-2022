package com.epam.training.microservices.monolithic.jpa.entity.recipie;

import com.epam.training.microservices.monolithic.jpa.entity.drug.DrugEntity;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * One line of the recipie. 
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {
    "drug",
    "recipe"
})
@Table(name = "recipe_lines")
public class RecipeLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "recipe_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private RecipeEntity recipe;

    /**
     * A drug to apply. 
     */
    @JoinColumn(name = "drug_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private DrugEntity drug;

    /**
     * Amount of drug to apply. 
     */
    private Long amount; 

    /**
     * What exactly to be done. 
     */
    private String instruction;
}
