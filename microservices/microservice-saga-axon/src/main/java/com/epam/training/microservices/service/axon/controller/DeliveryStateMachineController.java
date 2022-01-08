package com.epam.training.microservices.service.axon.controller;

import com.epam.training.microservices.service.axon.model.Order;
import com.epam.training.microservices.service.axon.query.FindAllOrdersQuery;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Aleksandr Barmin
 */
@Controller
@RequestMapping("/orders")
@RequiredArgsConstructor
public class DeliveryStateMachineController {
  private final QueryGateway queryGateway;

  @ModelAttribute("orders")
  public List<Order> allOrders() throws Exception {
    final CompletableFuture<List<Order>> queryFuture = queryGateway.query(
        new FindAllOrdersQuery(),
        ResponseTypes.multipleInstancesOf(Order.class)
    );
    final List<Order> orders = queryFuture.get();
    return orders;
  }

  @GetMapping("/")
  public ModelAndView allOrders(final ModelAndView modelAndView) throws Exception {
    modelAndView.setViewName("orders");
    return modelAndView;
  }
}
