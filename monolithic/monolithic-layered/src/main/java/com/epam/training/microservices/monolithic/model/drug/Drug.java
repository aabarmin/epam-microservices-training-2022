package com.epam.training.microservices.monolithic.model.drug;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.google.common.collect.Sets;
import java.util.Set;
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
