package com.epam.training.microservices.monolithic.model.drug;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.model.disease.Symptom;
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
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A drug that cures a collection of diseases or symptoms.
 */
@Data
@Entity
@Table(name = "drugs")
@EqualsAndHashCode(exclude = {
    "diseases",
    "symptoms"
})
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Name of the drug.
     */
    private String name; 

    /**
     * Description of the drug. 
     */
    private String description;

    /**
     * If the drug is available for the wide audience and can be used. 
     */
    private boolean available = false;

    /**
     * A collection of diseases that are cured by this drug. 
     */
    @ManyToMany(fetch = FetchType.LAZY)    
    @JoinTable(
        name = "drug_diseases",
        joinColumns = @JoinColumn(name = "drug_id"),
        inverseJoinColumns = @JoinColumn(name = "disease_id")
    )
    private Set<Disease> diseases = Sets.newHashSet();

    /**
     * A collection of symptoms this drug can help with. 
     */
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "drug_symptoms",
        joinColumns = @JoinColumn(name = "drug_id"),
        inverseJoinColumns = @JoinColumn(name = "symptom_id")
    )
    private Set<Symptom> symptoms = Sets.newHashSet();
}
