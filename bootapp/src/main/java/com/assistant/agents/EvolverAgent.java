package com.assistant.agents;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EvolverAgent extends Agent {
    private static final Logger log = LoggerFactory.getLogger(EvolverAgent.class);

    public EvolverAgent(String prompt) {
        super(AgentType.EVOLVER, prompt);
    }

    @Override
    public void perform() {
        log.info("Evolving prompts with: {}", systemPrompt);
        // stub evolution logic
    }
}
