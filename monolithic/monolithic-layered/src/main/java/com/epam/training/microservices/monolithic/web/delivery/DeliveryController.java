package com.epam.training.microservices.monolithic.web.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.service.CrudService;
import com.epam.training.microservices.monolithic.service.delivery.DeliveryService;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllSupport;
import com.epam.training.microservices.monolithic.web.crud.all.ViewAllTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.all.column.LinkColumnModel;
import com.epam.training.microservices.monolithic.web.crud.all.column.TextColumnModel;

import com.epam.training.microservices.monolithic.web.crud.single.details.ViewSingleDetailsSupport;
import com.epam.training.microservices.monolithic.web.crud.single.details.ViewSingleDetailsTemplateParams;
import com.epam.training.microservices.monolithic.web.crud.single.form.HiddenFieldModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.SelectFieldModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.TextFieldModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
@RequiredArgsConstructor
@RequestMapping("/delivery")
public class DeliveryController implements ViewAllSupport<Delivery>, ViewSingleDetailsSupport<Delivery> {
    private final DeliveryService deliveryService;
    private final DeliveryTransformer deliveryTransformer;

    @Override
    public CrudService<Delivery> getService() {
        return deliveryService;
    }

    @Override
    public ViewAllTemplateParams getViewAllTemplateParams() {
        return ViewAllTemplateParams.builder()
                .title("Delivery")
                .column(new LinkColumnModel<>("Address", Delivery::getAddressLine, d -> "/delivery/" + d.getId()))
                .column(new TextColumnModel<Delivery>("Status", d -> d.getStatus().name()))
                .build();
    }

    @Override
    public ViewSingleDetailsTemplateParams getViewSingleTemplateParams(Delivery parent) {
        return ViewSingleDetailsTemplateParams.builder()
                .title("Edit delivery")
                .field(new HiddenFieldModel("id", "id"))
                .field(new TextFieldModel("Address", "addressLine"))
                .field(new TextFieldModel("Status", "status"))
                .field(new SelectFieldModel("Pharmacy", "pharmacy",
                        parent.getPharmacy().getId(), deliveryTransformer.getPharmacies()))
                .headers(Arrays.asList("Drug", "Amount"))
                .detailObjectName("content")
                .details(deliveryTransformer.getContent(parent))
                .build();
    }
}
