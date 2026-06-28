package com.valka.analytics.model.dto;

import java.time.Instant;

public record UserActivityCreateRequest(String userId,
                                        String action,
                                        String resourceId,
                                        Instant createdAt,
                                        DeviceDetailsDto deviceDetails
) {}
