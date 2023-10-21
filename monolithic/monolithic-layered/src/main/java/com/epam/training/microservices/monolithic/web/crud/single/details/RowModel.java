package com.epam.training.microservices.monolithic.web.crud.single.details;

import com.epam.training.microservices.monolithic.web.crud.single.form.FieldModel;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class RowModel {
    @Singular
    private List<FieldModel> fields;
}
