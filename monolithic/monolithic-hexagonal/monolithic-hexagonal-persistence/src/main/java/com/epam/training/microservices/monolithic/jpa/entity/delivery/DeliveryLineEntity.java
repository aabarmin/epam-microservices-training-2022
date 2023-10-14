package com.epam.training.microservices.monolithic.jpa.entity.delivery;

import com.epam.training.microservices.monolithic.jpa.entity.drug.DrugEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "delivery_line")
public class DeliveryLineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "delivery_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private DeliveryEntity delivery;

    /**
     * A drug to deliver.
     */
    @JoinColumn(name = "drug_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private DrugEntity drug;

    /**
     * Amount of drug to deliver.
     */
    private Long amount;
}
