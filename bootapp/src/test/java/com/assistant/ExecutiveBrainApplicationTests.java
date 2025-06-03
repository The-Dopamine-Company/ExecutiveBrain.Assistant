package com.assistant;

import com.assistant.agents.AgentRegistry;
import com.assistant.agents.AgentType;
import com.assistant.agents.PlannerAgent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class ExecutiveBrainApplicationTests {

	@Test
	void contextLoads() {
	}

    @Test
    void registryLoads() {
        AgentRegistry registry = new AgentRegistry();
        registry.register(new PlannerAgent("test"));
        assertNotNull(registry.getAgent(AgentType.PLANNER));
    }
}
