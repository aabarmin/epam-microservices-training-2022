package com.epam.training.microservices.monolithic.exception.handler;

import com.epam.training.microservices.monolithic.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
class MonolithicControllerExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView resourceNotFoundExceptionHandler(HttpServletRequest req, ResourceNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("resourceName", e.getResourceName());
        modelAndView.addObject("resourceId", e.getResourceId());
        modelAndView.setViewName("error/resource-not-found");
        return modelAndView;
    }
}
