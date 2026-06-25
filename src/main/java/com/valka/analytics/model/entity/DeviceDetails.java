package com.valka.analytics.model.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DeviceDetails {
    private String os;
    private String browser;
    private String ipAddress;
}
