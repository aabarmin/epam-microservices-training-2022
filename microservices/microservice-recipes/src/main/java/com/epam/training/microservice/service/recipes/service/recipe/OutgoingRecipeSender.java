package com.epam.training.microservice.service.recipes.service.recipe;

import com.epam.training.microservice.service.recipes.model.OutgoingRecipe;
import com.epam.training.microservice.service.recipes.model.Recipe;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class OutgoingRecipeSender {
  private final OutgoingRecipeService outgoingRecipeService;

  private final StreamBridge streamBridge;

  @Transactional
  @Scheduled(initialDelay = 1_000, fixedDelay = 10_000)
  public Collection<Recipe> prepareForSend() {
    final List<Recipe> forSend = outgoingRecipeService.findUnprocessed()
        .stream()
        .map(outgoingRecipeService::markSent)
        .map(OutgoingRecipe::getRecipe)
        .collect(Collectors.toList());

    forSend.stream()
        .map(item -> MessageBuilder.withPayload(item).build())
        .forEach(message -> streamBridge.send("deliveryNotificator-out-0", message));

    return forSend;
  }
}
