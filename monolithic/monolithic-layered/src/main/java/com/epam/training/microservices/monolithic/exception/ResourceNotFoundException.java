package com.epam.training.microservices.monolithic.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResourceNotFoundException extends RuntimeException {
    private final String resourceName;
    private final Long resourceId;
}
