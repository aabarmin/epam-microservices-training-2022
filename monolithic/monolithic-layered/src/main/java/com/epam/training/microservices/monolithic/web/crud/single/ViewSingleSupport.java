package com.epam.training.microservices.monolithic.web.crud.single;

import com.epam.training.microservices.monolithic.exception.ResourceNotFoundException;
import com.epam.training.microservices.monolithic.web.crud.CrudSupport;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public interface ViewSingleSupport<T> extends CrudSupport<T> {
  ViewSingleTemplateParams getViewSingleTemplateParams();

  @GetMapping("/{id}")
  default ModelAndView viewSingle(ModelAndView modelAndView, @PathVariable("id") Long id) {
    T resource = getService().findOne(id)
            .orElseThrow(() -> new ResourceNotFoundException(getResourceName(), id));

    final ViewSingleTemplateParams templateParams = getViewSingleTemplateParams();

    modelAndView.setViewName(templateParams.getViewName());
    modelAndView.addObject("pageTitle", templateParams.getTitle());
    modelAndView.addObject("item", resource);
    modelAndView.addObject("submitTarget", getSubmitTarget());
    modelAndView.addObject("templateParams", templateParams);
    return modelAndView;
  }
}
