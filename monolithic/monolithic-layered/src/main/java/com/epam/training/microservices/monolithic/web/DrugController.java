package com.epam.training.microservices.monolithic.web;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.service.CrudService;
import com.epam.training.microservices.monolithic.service.drug.DrugService;
import com.epam.training.microservices.monolithic.web.crud.CrudController;
import com.epam.training.microservices.monolithic.web.crud.all.column.LinkColumnModel;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.single.form.HiddenFieldModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.TextFieldModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drugs")
public class DrugController implements CrudController<Drug> {
  @Autowired
  private DrugService drugService;

  @Override
  public ViewAllTemplateParams getViewAllTemplateParams() {
    return ViewAllTemplateParams.builder()
        .title("Drugs")
        .column(new LinkColumnModel<>("Name", Drug::getName, drug -> "/drugs/" + drug.getId()))
        .build();
  }

  @Override
  public ViewSingleTemplateParams getViewSingleTemplateParams() {
    return ViewSingleTemplateParams.builder()
        .title("Edit Drug")
        .field(new HiddenFieldModel("id", "id"))
        .field(new TextFieldModel("Name", "name"))
        .build();
  }

  @Override
  public CrudService<Drug> getService() {
    return drugService;
  }
}
