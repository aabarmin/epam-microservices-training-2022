package com.epam.training.microservices.monolithic.web;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.service.CrudService;
import com.epam.training.microservices.monolithic.service.pharmacy.PharmacyService;
import com.epam.training.microservices.monolithic.web.crud.CrudController;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.all.column.LinkColumnModel;
import com.epam.training.microservices.monolithic.web.crud.all.column.TextColumnModel;
import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.single.form.HiddenFieldModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.TextFieldModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pharmacies")
public class PharmaciesController implements CrudController<Pharmacy> {
  @Autowired
  private PharmacyService pharmacyService;

  @Override
  public CrudService getService() {
    return pharmacyService;
  }

  @Override
  public ViewAllTemplateParams getViewAllTemplateParams() {
    return ViewAllTemplateParams.builder()
        .title("Pharmacies")
        .column(new LinkColumnModel<>("Name", Pharmacy::getName, p -> "/pharmacies/" + p.getId()))
        .column(new TextColumnModel<>("Address", Pharmacy::getAddress))
        .build();
  }

  @Override
  public ViewSingleTemplateParams getViewSingleTemplateParams() {
    return ViewSingleTemplateParams.builder()
        .title("Edit Pharmacy")
        .field(new HiddenFieldModel("id", "id"))
        .field(new TextFieldModel("Name", "name"))
        .field(new TextFieldModel("Address", "address"))
        .build();
  }
}
