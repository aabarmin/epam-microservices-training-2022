package com.epam.training.microservices.monolithic.model.delivery;

/**
 * Status of the com.epam.training.service.delivery.
 */
public enum DeliveryStatus {
    IN_QUEUE, 
    IN_PROGRESS, 
    COMPLETED, 
    FAILED;
}
