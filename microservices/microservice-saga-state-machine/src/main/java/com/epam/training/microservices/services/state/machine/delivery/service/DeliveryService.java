package com.epam.training.microservices.services.state.machine.delivery.service;

import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryEvent;
import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryState;
import lombok.SneakyThrows;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class DeliveryService {
  private final StateMachineFactory<DeliveryState, DeliveryEvent> factory;

  private final StateMachinePersister<DeliveryState, DeliveryEvent, String> persister;

  public DeliveryService(
          StateMachineFactory<DeliveryState, DeliveryEvent> factory,
          StateMachinePersist<DeliveryState, DeliveryEvent, String> repository
  ) {
    this.factory = factory;
    this.persister = new DefaultStateMachinePersister<>(repository);
  }

  @SneakyThrows
  public void confirmOrder(String orderId) {
    final StateMachine<DeliveryState, DeliveryEvent> stateMachine = getStateMachine();
    stateMachine.getExtendedState().getVariables().put("ORDER_ID", orderId);
    stateMachine.sendEvent(DeliveryEvent.CONFIRM);

    persister.persist(stateMachine, orderId);
  }

  @SneakyThrows
  public void rejectOrder(String orderId) {
    withMachine(orderId, (machine) -> machine.sendEvent(DeliveryEvent.REJECT));
  }

  @SneakyThrows
  public void startDelivery(String orderId) {
    withMachine(orderId, (machine) -> machine.sendEvent(DeliveryEvent.START_DELIVERY));
  }

  @SneakyThrows
  public void completeDelivery(String orderId) {
    withMachine(orderId, (machine) -> machine.sendEvent(DeliveryEvent.END_DELIVERY));
  }

  @SneakyThrows
  private void withMachine(String contextId,
                           Consumer<StateMachine<DeliveryState, DeliveryEvent>> consumer) {

    final StateMachine<DeliveryState, DeliveryEvent> stateMachine = getStateMachine();
    persister.restore(stateMachine, contextId);
    consumer.accept(stateMachine);
    persister.persist(stateMachine, contextId);
  }

  private StateMachine<DeliveryState, DeliveryEvent> getStateMachine() {
    return factory.getStateMachine("deliveryStateMachine");
  }
}
