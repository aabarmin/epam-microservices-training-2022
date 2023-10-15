package com.epam.training.microservices.monolithic.web.crud.single.details;

import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleTemplateParams;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.List;

@Data
@SuperBuilder
public class ViewSingleDetailsTemplateParams extends ViewSingleTemplateParams {
    @Builder.Default
    protected String viewName = "common/single/item_details";
    private String detailObjectName;
    private List<String> headers;
    private Collection<RowModel> details;

}
