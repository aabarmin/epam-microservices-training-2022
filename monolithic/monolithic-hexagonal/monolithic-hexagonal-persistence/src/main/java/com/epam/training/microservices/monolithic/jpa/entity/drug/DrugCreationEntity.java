package com.epam.training.microservices.monolithic.jpa.entity.drug;

import com.epam.training.microservices.monolithic.jpa.entity.disease.DiseaseEntity;
import com.epam.training.microservices.monolithic.jpa.entity.disease.SymptomEntity;
import com.google.common.collect.Sets;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * An information about creation of the drug for the particular disease.
 */
@Data
@Entity
@Table(name = "drug_creation")
public class DrugCreationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Information about the drug to be created.
     */
    @JoinColumn(name = "drug_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private DrugEntity drug;

    /**
     * Symptoms to be cured by the drug.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "drug_creation_symptoms",
        joinColumns = @JoinColumn(name = "drug_creation_id"),
        inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private Set<SymptomEntity> symptoms = Sets.newHashSet();

    /**
     * Diseases to be cured by the drug.
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "drug_creation_diseases",
        joinColumns = @JoinColumn(name = "drug_creation_id"),
        inverseJoinColumns = @JoinColumn(name = "disease_id")
    )
    private Set<DiseaseEntity> diseases = Sets.newHashSet();
}
