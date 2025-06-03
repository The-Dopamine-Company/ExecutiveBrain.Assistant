package com.assistant.agents;

import com.assistant.comms.CommunicationInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NudgeAgent extends Agent {
    private static final Logger log = LoggerFactory.getLogger(NudgeAgent.class);
    private final CommunicationInterface comms;

    public NudgeAgent(String prompt, CommunicationInterface comms) {
        super(AgentType.NUDGE, prompt);
        this.comms = comms;
    }

    @Override
    public void perform() {
        log.info("Sending nudge with prompt: {}", systemPrompt);
        comms.sendText("Time to start your task!");
    }
}
