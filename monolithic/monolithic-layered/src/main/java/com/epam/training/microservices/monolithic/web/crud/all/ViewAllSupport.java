package com.epam.training.microservices.monolithic.web.crud.all;

import com.epam.training.microservices.monolithic.web.crud.CrudSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

public interface ViewAllSupport<T> extends CrudSupport<T> {
  ViewAllTemplateParams getViewAllTemplateParams();

  @GetMapping("")
  default ModelAndView viewAll(ModelAndView modelAndView) {
    final ViewAllTemplateParams templateParams = getViewAllTemplateParams();

    modelAndView.setViewName(templateParams.getViewName());
    modelAndView.addObject("items", getService().findAll());
    modelAndView.addObject("templateParams", templateParams);
    modelAndView.addObject("pageTitle", templateParams.getTitle());
    return modelAndView;
  }
}
