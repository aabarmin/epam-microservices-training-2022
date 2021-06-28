package com.epam.training.microservices.monolithic.web.crud.all;

import com.epam.training.microservices.monolithic.web.crud.all.column.TextColumnModel;
import java.util.Collection;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

@Data
@Builder
public class ViewAllTemplateParams {
  private String title;
  @Singular
  private List<TextColumnModel> columns;
  @Builder.Default
  private String viewName = "common/index";
}
