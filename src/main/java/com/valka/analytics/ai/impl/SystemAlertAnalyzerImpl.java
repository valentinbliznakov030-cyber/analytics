package com.valka.analytics.ai.impl;

import com.valka.analytics.ai.SystemAlertAnalyzer;
import com.valka.analytics.model.entity.SystemAlertLog;
import com.valka.analytics.repository.SystemAlertLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(
        prefix = "app.ai",
        name = "enabled",
        havingValue = "true"
)
public class SystemAlertAnalyzerImpl implements SystemAlertAnalyzer {
    private final SystemAlertLogRepository repository;
    private final ChatModel chatModel;

    @Override
    public void analyzeAndAppend(SystemAlertLog log) {
        String prompt = "You are a Senior DevOps Engineer. Analyze this error from service '"
                + log.getServiceName() + "': " + log.getMessage()
                + ". Provide a short summary and root cause in 2 sentences.";

        String response = chatModel.call(prompt);

        log.setAiAnalysis(response);
        repository.save(log);
    }
}
