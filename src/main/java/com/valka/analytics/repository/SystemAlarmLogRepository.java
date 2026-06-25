package com.valka.analytics.repository;

import com.valka.analytics.model.entity.SystemAlertLog;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAlarmLogRepository extends MongoRepository<SystemAlertLog, String> {
    Page<SystemAlertLog> findBySeverity(String severity);
}
