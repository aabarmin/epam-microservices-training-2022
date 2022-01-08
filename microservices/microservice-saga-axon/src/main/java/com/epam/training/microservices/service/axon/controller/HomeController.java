package com.epam.training.microservices.service.axon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Aleksandr Barmin
 */
@Controller
public class HomeController {
  @GetMapping("/")
  public RedirectView redirect() {
    return new RedirectView("/orders");
  }
}
