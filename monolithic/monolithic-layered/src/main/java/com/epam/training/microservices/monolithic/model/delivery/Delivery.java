package com.epam.training.microservices.monolithic.model.delivery;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Stores information about the delivery.
 */
@Data
@Entity
@Table(name = "deliveries")
@ToString(exclude = {
    "pharmacy",
    "content"
})
@EqualsAndHashCode(exclude = {
    "pharmacy",
    "content"
})
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @JoinColumn(name = "pharmacy_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Pharmacy pharmacy;

    /**
     * Content of the delivery.
     */
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "delivery")
    private List<DeliveryLine> content;
}
