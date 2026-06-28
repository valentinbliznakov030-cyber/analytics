package com.valka.analytics.service;

import com.valka.analytics.model.dto.SystemAlertCreateRequest;
import com.valka.analytics.model.entity.SystemAlertLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;

public interface SystemAlertLogService {
    SystemAlertLog logAlert(SystemAlertCreateRequest request);

    Page<SystemAlertLog> getLogsBySeverity(String severity, Pageable pageable);

    Page<SystemAlertLog> getLogsInPeriod(Instant start, Instant end, Pageable pageable);
}
