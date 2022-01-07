package com.epam.training.microservices.monolithic.loader.disease;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * The model is used to import data from json.
 */
@Data
public class DiseaseLoadModel {
  private String disease;
  private List<String> symptoms = Lists.newArrayList();
  private List<String> treatments = Lists.newArrayList();
  private List<String> drugs = Lists.newArrayList();
}
