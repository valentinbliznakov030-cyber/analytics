package com.valka.analytics.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemAlertLog {
    @Id
    private String id;

    @Indexed(name = "alert_severity_idx")
    private String severity;

    private String serviceName;
    private String message;
    private String traceId;

    private Instant timestamp;
}
