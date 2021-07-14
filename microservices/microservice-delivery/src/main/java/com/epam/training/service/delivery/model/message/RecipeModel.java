package com.epam.training.service.delivery.model.message;

import com.google.common.collect.Lists;
import lombok.Data;

import java.time.LocalDate;
import java.util.Collection;

@Data
public class RecipeModel {
    private Long id;
    private PersonModel doctor;
    private PersonModel recipient;
    private Collection<RecipeLineModel> lines = Lists.newArrayList();
    private LocalDate issueDate;
}
