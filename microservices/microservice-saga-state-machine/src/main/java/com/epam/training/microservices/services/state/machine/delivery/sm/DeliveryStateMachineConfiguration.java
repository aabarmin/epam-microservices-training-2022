package com.epam.training.microservices.services.state.machine.delivery.sm;

import com.epam.training.microservices.services.state.machine.delivery.action.OnCompleteDeliveryAction;
import com.epam.training.microservices.services.state.machine.delivery.action.OnRejectAction;
import com.epam.training.microservices.services.state.machine.delivery.action.OnStartDeliveryAction;
import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryEvent;
import com.epam.training.microservices.services.state.machine.delivery.model.DeliveryState;
import java.util.EnumSet;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.EnableStateMachineFactory;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListener;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.statemachine.transition.Transition;

@Configuration
@EnableStateMachineFactory
public class DeliveryStateMachineConfiguration
    extends EnumStateMachineConfigurerAdapter<DeliveryState, DeliveryEvent> {

  @Autowired
  private OnRejectAction rejectAction;

  @Autowired
  private OnStartDeliveryAction startDeliveryAction;

  @Autowired
  private OnCompleteDeliveryAction completeDeliveryAction;

  @Override
  public void configure(StateMachineConfigurationConfigurer<DeliveryState, DeliveryEvent> config) throws Exception {
    config.withConfiguration()
        .autoStartup(true)
        .machineId("deliveryStateMachine")
        .listener(eventStateMachineListener());
  }

  @Override
  public void configure(StateMachineStateConfigurer<DeliveryState, DeliveryEvent> states) throws Exception {
    states.withStates()
        .initial(DeliveryState.CONFIRMED)
        .end(DeliveryState.DELIVERED)
        .states(EnumSet.allOf(DeliveryState.class));
  }

  @Override
  public void configure(StateMachineTransitionConfigurer<DeliveryState, DeliveryEvent> transitions) throws Exception {
    transitions
        .withExternal()
            .source(DeliveryState.CONFIRMED)
            .target(DeliveryState.NOT_AVAILABLE)
            .event(DeliveryEvent.REJECT)
            .action(rejectAction)
            .and()
        .withExternal()
            .source(DeliveryState.CONFIRMED)
            .target(DeliveryState.DELIVERY)
            .event(DeliveryEvent.START_DELIVERY)
            .action(startDeliveryAction)
            .and()
        .withExternal()
            .source(DeliveryState.DELIVERY)
            .target(DeliveryState.DELIVERED)
            .event(DeliveryEvent.END_DELIVERY)
            .action(completeDeliveryAction);
  }

  @Bean
  public StateMachineListener<DeliveryState, DeliveryEvent> eventStateMachineListener() {
    return new StateMachineListenerAdapter<>() {
      @Override
      public void stateMachineStarted(StateMachine<DeliveryState, DeliveryEvent> stateMachine) {
        System.out.println("State machine started, use reject or start to proceed");
      }

      @Override
      public void stateEntered(State<DeliveryState, DeliveryEvent> state) {
        System.out.println("State machine enters state " + state.getId());
      }

      @Override
      public void stateExited(State<DeliveryState, DeliveryEvent> state) {
        System.out.println("State machine exits state " + state.getId());
      }

      @Override
      public void transition(Transition<DeliveryState, DeliveryEvent> transition) {
        System.out.println(String.format(
            "Transition %s -> %s",
            Optional.ofNullable(transition.getSource()).map(State::getId).orElse(DeliveryState.CONFIRMED),
            transition.getTarget().getId()
        ));
      }
    };
  }
}
