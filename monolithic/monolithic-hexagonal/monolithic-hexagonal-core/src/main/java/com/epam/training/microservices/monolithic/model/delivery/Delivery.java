package com.epam.training.microservices.monolithic.model.delivery;

import com.epam.training.microservices.monolithic.model.HasId;
import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.google.common.collect.Sets;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Stores information about the delivery. 
 */
@Data
@EqualsAndHashCode(exclude = {
    "pharmacy",
    "content"
})
public class Delivery implements HasId<Long> {
    private Long id;

    /**
     * Address of the delivery.
     */
    private String addressLine; 

    /**
     * Status of the delivery. 
     */
    private DeliveryStatus status;

    /**
     * Where from.
     */
    private Pharmacy pharmacy;

    /**
     * Content of the delivery. 
     */
    private Set<DeliveryLine> content = Sets.newHashSet();
}
