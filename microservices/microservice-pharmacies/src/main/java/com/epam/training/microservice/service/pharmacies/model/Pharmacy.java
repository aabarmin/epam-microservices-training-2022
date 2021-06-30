package com.epam.training.microservice.service.pharmacies.model;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "pharmacies")
@EqualsAndHashCode(exclude = "available")
public class Pharmacy {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;
  private String address;

  @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
  private Set<PharmacyAvailable> available = Sets.newHashSet();
}
