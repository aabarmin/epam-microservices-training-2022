package com.epam.training.microservice.service.recipes.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 */
@Data
@Entity
@Table(name = "recipients")
@ToString(exclude = {
        "recipes"
})
@EqualsAndHashCode(exclude = {
        "recipes"
})
public class Recipient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Recipient name, etc. 
     */
    private String firstName; 
    private String lastName; 

    /**
     * A collection of recipes associated with this recipient.
     */
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Recipe> recipes = new HashSet<>();
}
