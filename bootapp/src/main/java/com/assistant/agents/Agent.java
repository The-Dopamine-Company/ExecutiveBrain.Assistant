package com.assistant.agents;

import java.util.ArrayList;
import java.util.List;

/**
 * Base agent holding prompt and simple history.
 */
public abstract class Agent {
    protected AgentType type;
    protected String systemPrompt;
    protected List<String> evolutionHistory = new ArrayList<>();

    public Agent(AgentType type, String prompt) {
        this.type = type;
        this.systemPrompt = prompt;
    }

    public AgentType getType() {
        return type;
    }

    public String getSystemPrompt() {
        return systemPrompt;
    }

    public void evolvePrompt(String newPrompt) {
        evolutionHistory.add(systemPrompt);
        systemPrompt = newPrompt;
    }

    public abstract void perform();
}
