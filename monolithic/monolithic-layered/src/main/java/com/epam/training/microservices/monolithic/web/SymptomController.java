package com.epam.training.microservices.monolithic.web;

import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.epam.training.microservices.monolithic.service.CrudService;
import com.epam.training.microservices.monolithic.service.symptom.SymptomService;

import com.epam.training.microservices.monolithic.web.crud.CrudController;
import com.epam.training.microservices.monolithic.web.crud.all.column.LinkColumnModel;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.single.form.HiddenFieldModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.TextFieldModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * A controller to manage symptoms. 
 */
@RestController
@RequestMapping("/symptoms")
public class SymptomController implements CrudController<Symptom> {
    @Autowired
    private SymptomService symptomService;

    @Override
    public ViewAllTemplateParams getViewAllTemplateParams() {
        return ViewAllTemplateParams.builder()
            .title("Symptoms")
            .column(new LinkColumnModel<>("Name", Symptom::getName, s -> "/symptoms/" + s.getId()))
            .build();
    }

    @Override
    public ViewSingleTemplateParams getViewSingleTemplateParams() {
        return ViewSingleTemplateParams.builder()
            .title("Edit Symptom")
            .field(new HiddenFieldModel("id", "id"))
            .field(new TextFieldModel("Name", "name"))
            .build();
    }

    @Override
    public CrudService<Symptom> getService() {
        return symptomService;
    }
}
