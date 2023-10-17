package com.epam.training.microservices.monolithic.web.delivery;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.model.delivery.DeliveryLine;
import com.epam.training.microservices.monolithic.service.drug.DrugService;
import com.epam.training.microservices.monolithic.service.pharmacy.PharmacyService;
import com.epam.training.microservices.monolithic.web.crud.SelectItem;

import java.util.Collection;
import java.util.stream.Collectors;

import com.epam.training.microservices.monolithic.web.crud.single.details.RowModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.HiddenFieldModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.SelectFieldModel;
import com.epam.training.microservices.monolithic.web.crud.single.form.TextFieldModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeliveryTransformer {
    private final PharmacyService pharmacyService;
    private final DrugService drugService;

    public Collection<SelectItem> getPharmacies() {
        return pharmacyService.findAll()
                .stream()
                .map(ph -> new SelectItem(ph.getId(), ph.getName()))
                .collect(Collectors.toList());
    }


    public Collection<RowModel> getContent(Delivery delivery) {
        return delivery.getContent()
                .stream()
                .map(this::getRowModel)
                .collect(Collectors.toList());
    }

    private RowModel getRowModel(DeliveryLine line) {
        return RowModel.builder()
                .field(new SelectFieldModel("Drugs", "drug", line.getDrug().getId(), getDrugs()))
                .field(new TextFieldModel("Amount", "amount"))
                .field(new HiddenFieldModel("id", "id"))
                .field(new HiddenFieldModel("parent", "delivery.id"))
                .build();
    }

    private Collection<SelectItem> getDrugs() {
        return drugService.findAll()
                .stream()
                .map(d -> new SelectItem(d.getId(), d.getName()))
                .collect(Collectors.toList());
    }
}
