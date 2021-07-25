package com.epam.training.microservices.services.state.machine.delivery.action;

import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryEvent;
import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

@Component
public class OnRejectAction implements Action<DeliveryState, DeliveryEvent> {
  @Override
  public void execute(StateContext<DeliveryState, DeliveryEvent> context) {
    System.out.println("The order is rejected");
  }
}
