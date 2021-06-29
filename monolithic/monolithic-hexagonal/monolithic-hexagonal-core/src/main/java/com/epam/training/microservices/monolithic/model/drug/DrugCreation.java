package com.epam.training.microservices.monolithic.model.drug;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.google.common.collect.Sets;
import java.util.Set;
import lombok.Data;

/**
 * An information about creation of the drug for the particular disease. 
 */
@Data
public class DrugCreation {
    private Long id;

    /**
     * Information about the drug to be created. 
     */
    private Drug drug;

    /**
     * Symptoms to be cured by the drug. 
     */
    private Set<Symptom> symptoms = Sets.newHashSet();

    /**
     * Diseases to be cured by the drug. 
     */
    private Set<Disease> diseases = Sets.newHashSet();
}
