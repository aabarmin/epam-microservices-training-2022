package com.epam.training.microservices.monolithic.service.load.disease;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.Data;

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
