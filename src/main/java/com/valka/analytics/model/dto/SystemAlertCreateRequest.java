package com.valka.analytics.model.dto;

import java.time.Instant;

public record SystemAlertCreateRequest(
        String severity,
        String serviceName,
        String message,
        String traceId,
        Instant timestamp
) {}
