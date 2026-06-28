package com.valka.analytics.service.impl;

import com.valka.analytics.model.dto.SystemAlertCreateRequest;
import com.valka.analytics.model.entity.SystemAlertLog;
import com.valka.analytics.repository.SystemAlertLogRepository;
import com.valka.analytics.service.SystemAlertLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class SystemAlertLogServiceImpl implements SystemAlertLogService {
    private final SystemAlertLogRepository repository;

    @Override
    public SystemAlertLog logAlert(SystemAlertCreateRequest request) {
        SystemAlertLog entity = SystemAlertLog.builder()
                .severity(request.severity())
                .serviceName(request.serviceName())
                .message(request.message())
                .traceId(request.traceId())
                .timestamp(request.timestamp())
                .build();

        return repository.save(entity);
    }

    @Override
    public Page<SystemAlertLog> getLogsBySeverity(String severity, Pageable pageable) {
        return repository.findBySeverity(severity, pageable);
    }

    @Override
    public Page<SystemAlertLog> getLogsInPeriod(Instant start, Instant end, Pageable pageable) {
        return repository.findByTimestampBetween(start, end, pageable);
    }
}