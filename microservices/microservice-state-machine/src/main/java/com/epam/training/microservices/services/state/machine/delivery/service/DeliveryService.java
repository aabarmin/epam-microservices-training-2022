package com.epam.training.microservices.services.state.machine.delivery.service;

import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryEvent;
import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryState;
import java.util.function.Consumer;
import javax.annotation.PostConstruct;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.persist.DefaultStateMachinePersister;
import org.springframework.statemachine.persist.StateMachinePersister;
import org.springframework.stereotype.Component;

@Component
public class DeliveryService {
  @Autowired
  private StateMachineFactory<DeliveryState, DeliveryEvent> factory;

  @Autowired
  private StateMachinePersist<DeliveryState, DeliveryEvent, String> repository;

  private StateMachinePersister<DeliveryState, DeliveryEvent, String> persister;

  @PostConstruct
  public void init() {
    persister = new DefaultStateMachinePersister<>(repository);
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
