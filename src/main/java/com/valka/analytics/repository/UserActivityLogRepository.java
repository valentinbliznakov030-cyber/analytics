package com.valka.analytics.repository;

import com.valka.analytics.model.entity.UserActivityLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityLogRepository extends MongoRepository<UserActivityLog, String> {
    Page<UserActivityLog> findByUserIdAndAction(String userId, String action, Pageable pageable);
}
