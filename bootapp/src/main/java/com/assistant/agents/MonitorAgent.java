package com.assistant.agents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonitorAgent extends Agent {
    private static final Logger log = LoggerFactory.getLogger(MonitorAgent.class);

    public MonitorAgent(String prompt) {
        super(AgentType.MONITOR, prompt);
    }

    @Override
    public void perform() {
        log.info("Monitoring progress using prompt: {}", systemPrompt);
        // stub monitoring logic
    }
}
