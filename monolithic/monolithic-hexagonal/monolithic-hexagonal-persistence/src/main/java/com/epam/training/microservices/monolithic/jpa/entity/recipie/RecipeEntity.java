package com.epam.training.microservices.monolithic.jpa.entity.recipie;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.RecipeLine;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import com.google.common.collect.Sets;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * A recipie to apply. 
 */
@Data
@Entity
@Table(name = "recipes")
public class RecipeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * A doctor who issues the recipie.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private DoctorEntity doctor;

    /**
     * A recipient of the recipie. 
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private RecipientEntity recipient;

    /**
     * A content of the recipie. 
     */
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
    private Set<RecipeLineEntity> lines = Sets.newHashSet();

    /**
     * Issue date of the recipe.
     */
    private LocalDate issueDate;
}
