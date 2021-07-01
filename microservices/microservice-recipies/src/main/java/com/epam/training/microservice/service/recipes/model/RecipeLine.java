package com.epam.training.microservice.service.recipes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

/**
 * One line of the recipie. 
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {
    "recipe"
})
@ToString(exclude = {
        "recipe"
})
@JsonIgnoreProperties({
        "recipe"
})
@Table(name = "recipe_lines")
public class RecipeLine {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "recipe_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Recipe recipe;

    /**
     * A drug to apply. 
     */
    private Long drugId;

    /**
     * Amount of drug to apply. 
     */
    private Long amount; 

    /**
     * What exactly to be done. 
     */
    private String instruction;
}
