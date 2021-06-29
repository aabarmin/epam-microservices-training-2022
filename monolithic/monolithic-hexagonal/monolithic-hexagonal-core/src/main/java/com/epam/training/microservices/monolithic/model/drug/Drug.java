package com.epam.training.microservices.monolithic.model.drug;

import com.epam.training.microservices.monolithic.model.HasId;
import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.google.common.collect.Sets;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * A drug that cures a collection of diseases or symptoms.
 */
@Data
@EqualsAndHashCode(exclude = {
    "diseases",
    "symptoms"
})
public class Drug implements HasId<Long> {
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
    private Set<Disease> diseases = Sets.newHashSet();

    /**
     * A collection of symptoms this drug can help with. 
     */
    private Set<Symptom> symptoms = Sets.newHashSet();
}
