package com.epam.training.microservices.monolithic.model.recipie;

import com.epam.training.microservices.monolithic.model.HasId;
import lombok.Data;

/**
 * An entity to store information about doctors who issue the recipiees. 
 */
@Data
public class Doctor implements HasId<Long> {
    private Long id;

    /**
     * Doctor's name. 
     */
    private String firstName; 
    private String lastName;

}
