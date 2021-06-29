package com.epam.training.microservices.monolithic.jpa.entity.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.model.drug.Drug;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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
    private Drug drug;

    /**
     * Amount of drug to deliver. 
     */
    private Long amount;
}
