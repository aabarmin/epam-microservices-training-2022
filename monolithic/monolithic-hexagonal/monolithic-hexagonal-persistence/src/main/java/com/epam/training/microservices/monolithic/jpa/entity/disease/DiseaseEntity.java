package com.epam.training.microservices.monolithic.jpa.entity.disease;

import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 * Diseases. 
 */
@Data
@Entity
@Table(name = "diseases")
public class DiseaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the disease.
     */
    private String name; 

    /**
     * Description of the disease. 
     */
    private String description; 

    /**
     * A collection of symptoms related to the disease.
     */
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
        name = "disease_symptoms",
        joinColumns = @JoinColumn(name = "disease_id"),
        inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private Set<SymptomEntity> symptoms = Sets.newHashSet();
}
