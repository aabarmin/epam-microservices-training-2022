package com.epam.training.microservices.monolithic.web.crud.single.details;

import com.epam.training.microservices.monolithic.exception.ResourceNotFoundException;
import com.epam.training.microservices.monolithic.web.crud.CrudSupport;
import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleTemplateParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

public interface ViewSingleDetailsSupport<T> extends CrudSupport<T> {
  ViewSingleDetailsTemplateParams getViewSingleTemplateParams(T parent);

  @GetMapping("/{id}")
  @Transactional
  default ModelAndView viewSingleDetails(ModelAndView modelAndView, @PathVariable("id") Long id) {
    final T parent = getService().findOne(id)
            .orElseThrow(() -> new ResourceNotFoundException(getResourceName(), id));

    final ViewSingleTemplateParams templateParams = getViewSingleTemplateParams(parent);

    modelAndView.setViewName(templateParams.getViewName());
    modelAndView.addObject("pageTitle", templateParams.getTitle());
    modelAndView.addObject("item", parent);
    modelAndView.addObject("submitTarget", getSubmitTarget());
    modelAndView.addObject("templateParams", templateParams);
    return modelAndView;
  }
}
