package com.valka.analytics.ai;

import com.valka.analytics.model.entity.SystemAlertLog;

public interface SystemAlertAnalyzer {
    void analyzeAndAppend(SystemAlertLog log);
}
