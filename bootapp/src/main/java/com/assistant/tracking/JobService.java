package com.assistant.tracking;

import com.assistant.agents.AgentRegistry;
import com.assistant.agents.AgentType;
import com.assistant.comms.CommunicationInterface;
import com.assistant.comms.CommunicationJob;
import com.assistant.comms.JobType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

@Service
public class JobService {
    private static final Logger log = LoggerFactory.getLogger(JobService.class);
    private final Queue<CommunicationJob> queue = new LinkedList<>();
    private final AgentRegistry registry;
    private final CommunicationInterface comms;

    public JobService(AgentRegistry registry, CommunicationInterface comms) {
        this.registry = registry;
        this.comms = comms;
    }

    public void schedule(JobType type, String payload) {
        queue.offer(new CommunicationJob(type, Instant.now(), payload));
    }

    public void runOnce() {
        CommunicationJob job = queue.poll();
        if (job == null) {
            return;
        }
        switch (job.getType()) {
            case PLAN_TASK -> registry.getAgent(AgentType.PLANNER).perform();
            case NUDGE -> registry.getAgent(AgentType.NUDGE).perform();
            case VERIFY -> registry.getAgent(AgentType.MONITOR).perform();
            case EVOLVE -> registry.getAgent(AgentType.EVOLVER).perform();
            case REWARD -> registry.getAgent(AgentType.REWARDER).perform();
        }
    }
}
