package com.valka.analytics.service;

import com.valka.analytics.model.dto.UserActivityCreateRequest;
import com.valka.analytics.model.entity.UserActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.Instant;

public interface UserActivityLogService {
    UserActivityLog logActivity(UserActivityCreateRequest request);

    Page<UserActivityLog> getLogsByUserAndAction(String userId, String action, Pageable pageable);

    Page<UserActivityLog> getLogsInPeriod(Instant start, Instant end, Pageable pageable);
}
