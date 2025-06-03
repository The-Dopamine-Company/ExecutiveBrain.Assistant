package com.assistant.agents;

import java.util.HashMap;
import java.util.Map;

public class AgentRegistry {
    private final Map<AgentType, Agent> agents = new HashMap<>();

    public void register(Agent agent) {
        agents.put(agent.getType(), agent);
    }

    public Agent getAgent(AgentType type) {
        return agents.get(type);
    }
}
