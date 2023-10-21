package com.epam.training.microservices.monolithic.web.crud.single;

import com.epam.training.microservices.monolithic.web.crud.single.form.FieldModel;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class ViewSingleTemplateParams {
  private String title;
  @Builder.Default
  protected String viewName = "common/single/item_only";
  @Singular
  private List<FieldModel> fields;
}
