package com.epam.training.microservices.monolithic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeRedirectController {
  @GetMapping("/")
  public RedirectView redirectView() {
    return new RedirectView("/drugs");
  }
}
