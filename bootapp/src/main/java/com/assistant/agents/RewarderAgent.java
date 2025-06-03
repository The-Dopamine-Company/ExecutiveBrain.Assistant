package com.assistant.agents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RewarderAgent extends Agent {
    private static final Logger log = LoggerFactory.getLogger(RewarderAgent.class);

    public RewarderAgent(String prompt) {
        super(AgentType.REWARDER, prompt);
    }

    @Override
    public void perform() {
        log.info("Assigning rewards with prompt: {}", systemPrompt);
        // stub reward logic
    }
}
