package com.valka.analytics.service.impl;

import com.valka.analytics.model.dto.UserActivityCreateRequest;
import com.valka.analytics.model.entity.DeviceDetails;
import com.valka.analytics.model.entity.UserActivityLog;
import com.valka.analytics.repository.UserActivityLogRepository;
import com.valka.analytics.service.UserActivityLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UserActivityLogServiceImpl implements UserActivityLogService {
    private final UserActivityLogRepository repository;

    @Override
    public UserActivityLog logActivity(UserActivityCreateRequest request) {
        UserActivityLog entity = UserActivityLog
                .builder()
                .userId(request.userId())
                .action(request.action())
                .resourceId(request.resourceId())
                .createdAt(request.createdAt())
                .deviceDetails(DeviceDetails
                        .builder()
                        .os(request.deviceDetails().os())
                        .browser(request.deviceDetails().browser())
                        .ipAddress(request.deviceDetails().ipAddress())
                        .build())
                .build();

        return repository.save(entity);
    }

    @Override
    public Page<UserActivityLog> getLogsByUserAndAction(String userId, String action, Pageable pageable) {
        return repository.findByUserIdAndAction(userId, action, pageable);
    }

    @Override
    public Page<UserActivityLog> getLogsInPeriod(Instant start, Instant end, Pageable pageable) {
        return repository.findByCreatedAtBetween(start, end, pageable);
    }
}
