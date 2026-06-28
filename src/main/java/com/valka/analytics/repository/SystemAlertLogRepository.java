package com.valka.analytics.repository;

import com.valka.analytics.model.entity.SystemAlertLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public interface SystemAlertLogRepository extends MongoRepository<SystemAlertLog, String> {
    Page<SystemAlertLog> findBySeverity(String severity, Pageable pageable);

    Page<SystemAlertLog> findByTimestampBetween(Instant start, Instant end, Pageable pageable);
}
