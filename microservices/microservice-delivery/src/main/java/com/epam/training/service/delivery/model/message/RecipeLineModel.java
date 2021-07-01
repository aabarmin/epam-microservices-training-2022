package com.epam.training.service.delivery.model.message;

import lombok.Data;

@Data
public class RecipeLineModel {
    private Long drugId;
    private Long amount;
    private String instruction;
}
