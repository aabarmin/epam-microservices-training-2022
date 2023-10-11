package com.epam.training.microservices.monolithic.model.pharmacy;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import jakarta.persistence.Column;
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
public class PharmacyAvailable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JoinColumn(name = "pharmacy_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Pharmacy pharmacy;

  @JoinColumn(name = "drug_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Drug drug;

  private Long amount;
}
