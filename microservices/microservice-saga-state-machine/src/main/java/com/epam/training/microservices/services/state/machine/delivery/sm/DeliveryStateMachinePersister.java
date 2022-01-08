package com.epam.training.microservices.services.state.machine.delivery.sm;

import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryEvent;
import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.stereotype.Component;

@Component
public class DeliveryStateMachinePersister implements StateMachinePersist<DeliveryState,
    DeliveryEvent, String> {

  private final Map<String, StateMachineContext<DeliveryState, DeliveryEvent>> storage =
      new ConcurrentHashMap<>();

  @Override
  public void write(StateMachineContext<DeliveryState, DeliveryEvent> context, String contextObj) throws Exception {
    storage.put(contextObj, context);
  }

  @Override
  public StateMachineContext<DeliveryState, DeliveryEvent> read(String contextObj) throws Exception {
    return storage.get(contextObj);
  }
}
