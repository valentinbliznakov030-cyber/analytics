package com.valka.analytics.model.dto;

public record DeviceDetailsDto(
        String os,
        String browser,
        String ipAddress
) {}
