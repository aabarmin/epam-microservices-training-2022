package com.epam.training.microservices.monolithic.jpa.entity.pharmacy;

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
@Table(name = "pharmacy_available")
public class PharmacyAvailableEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JoinColumn(name = "pharmacy_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private PharmacyEntity pharmacy;

  @JoinColumn(name = "drug_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private DrugEntity drug;

  private Long amount;
}
