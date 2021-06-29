package com.epam.training.microservices.monolithic.model.delivery;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import lombok.Data;

@Data
public class DeliveryLine {
    private Long id;

    private Delivery delivery;

    /**
     * A drug to deliver. 
     */
    private Drug drug;

    /**
     * Amount of drug to deliver. 
     */
    private Long amount;
}
