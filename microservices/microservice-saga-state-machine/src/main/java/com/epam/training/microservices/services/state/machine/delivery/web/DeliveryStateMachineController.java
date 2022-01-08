package com.epam.training.microservices.services.state.machine.delivery.web;

import com.epam.training.microservices.services.state.machine.delivery.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeliveryStateMachineController {
  @Autowired
  private DeliveryService deliveryService;

  @GetMapping("/order/{id}/confirm")
  public void confirmOrder(@PathVariable("id") String id) {
    deliveryService.confirmOrder(id);
  }

  @GetMapping("/order/{id}/reject")
  public void rejectOrder(@PathVariable("id") String id) {
    deliveryService.rejectOrder(id);
  }

  @GetMapping("/order/{id}/start")
  public void startDelivery(@PathVariable("id") String id) {
    deliveryService.startDelivery(id);
  }

  @GetMapping("/order/{id}/complete")
  public void completeDelivery(@PathVariable("id") String id) {
    deliveryService.completeDelivery(id);
  }
}
