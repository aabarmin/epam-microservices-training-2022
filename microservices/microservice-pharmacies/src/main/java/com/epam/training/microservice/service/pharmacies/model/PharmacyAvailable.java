package com.epam.training.microservice.service.pharmacies.model;

import lombok.Data;

import javax.persistence.*;

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

  private Long drugId;
  private Long amount;
}
