package com.epam.training.microservices.monolithic.jpa.entity.recipie;

import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * 
 */
@Data
@Entity
@Table(name = "recipients")
public class RecipientEntity {
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
    @OneToMany(fetch = FetchType.LAZY)
    private Set<RecipeEntity> recipes = Sets.newHashSet();
}
