package com.epam.training.microservices.monolithic.web.crud.single.details;

import com.epam.training.microservices.monolithic.web.crud.CrudSupport;
import com.epam.training.microservices.monolithic.web.crud.single.ViewSingleTemplateParams;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

public interface ViewSingleDetailsSupport<T> extends CrudSupport<T> {
  ViewSingleDetailsTemplateParams getViewSingleTemplateParams(T parent);

  @GetMapping("/{id}")
  @Transactional
  default ModelAndView viewSingleDetails(ModelAndView modelAndView, @PathVariable("id") Long id) {
    final T parent = getService().findOne(id)
            .orElseThrow(() -> new RuntimeException("No item with id " + id));

    final ViewSingleTemplateParams templateParams = getViewSingleTemplateParams(parent);

    modelAndView.setViewName(templateParams.getViewName());
    modelAndView.addObject("pageTitle", templateParams.getTitle());
    modelAndView.addObject("item", parent);
    modelAndView.addObject("submitTarget", getSubmitTarget());
    modelAndView.addObject("templateParams", templateParams);
    return modelAndView;
  }

  @PostMapping("")
  default String saveSingle(@ModelAttribute T item) {
    getService().save(item);
    return "redirect:" + getSubmitTarget();
  }

  default String getSubmitTarget() {
    return Optional.ofNullable(this.getClass().getDeclaredAnnotation(RequestMapping.class))
        .map(RequestMapping::value)
        .map(values -> values[0])
        .orElseThrow(() -> new RuntimeException("No RequestMapping annotation"));
  }
}
