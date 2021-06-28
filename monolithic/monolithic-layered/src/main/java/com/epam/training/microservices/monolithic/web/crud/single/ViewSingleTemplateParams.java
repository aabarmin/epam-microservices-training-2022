package com.epam.training.microservices.monolithic.web.crud.single;

import com.epam.training.microservices.monolithic.web.crud.single.form.FieldModel;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class ViewSingleTemplateParams {
  private String title;
  @Builder.Default
  private String viewName = "common/single";
  @Singular
  private List<FieldModel> fields;
}
