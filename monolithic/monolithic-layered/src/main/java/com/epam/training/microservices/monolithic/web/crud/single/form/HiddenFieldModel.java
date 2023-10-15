package com.epam.training.microservices.monolithic.web.crud.single.form;

public class HiddenFieldModel<T> extends TextFieldModel<T> {

    public HiddenFieldModel(String title, String field) {
        super(title, field);
    }

    @Override
    public String getType() {
        return "HIDDEN";
    }

}
