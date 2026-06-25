package com.valka.analytics.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "user_activity_logs")
@CompoundIndexes({
        @CompoundIndex(name = "user_action_idx", def = "{'userId': 1, 'action': 1}")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserActivityLog {

    @Id
    private String id;

    private String userId;
    private String action;
    private String resourceId;

    @Indexed(name = "creation_time_idx", expireAfter = "30d")
    private Instant createdAt;

    private DeviceDetails deviceDetails;
}
