package com.epam.training.microservices.monolithic.web.crud;

import com.epam.training.microservices.monolithic.web.crud.all.ViewAllSupport;
import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleSupport;

public interface CrudController<T> extends ViewAllSupport, ViewSingleSupport {

}
