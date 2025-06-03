package com.assistant.agents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlannerAgent extends Agent {
    private static final Logger log = LoggerFactory.getLogger(PlannerAgent.class);

    public PlannerAgent(String prompt) {
        super(AgentType.PLANNER, prompt);
    }

    @Override
    public void perform() {
        log.info("Planning tasks using prompt: {}", systemPrompt);
        // stub planning logic
    }
}
