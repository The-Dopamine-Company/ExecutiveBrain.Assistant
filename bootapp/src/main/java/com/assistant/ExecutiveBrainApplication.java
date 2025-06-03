package com.assistant;

import com.assistant.agents.*;
import com.assistant.comms.CommunicationInterface;
import com.assistant.comms.JobType;
import com.assistant.tracking.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExecutiveBrainApplication {

    @Autowired
    private CommunicationInterface comms;

    @Bean
    public AgentRegistry registry() {
        AgentRegistry registry = new AgentRegistry();
        registry.register(new PlannerAgent(loadPrompt("planner.md")));
        registry.register(new NudgeAgent(loadPrompt("nudge.md"), comms));
        registry.register(new MonitorAgent(loadPrompt("monitor.md")));
        registry.register(new EvolverAgent(loadPrompt("evolver.md")));
        registry.register(new RewarderAgent(loadPrompt("rewarder.md")));
        return registry;
    }

    private String loadPrompt(String file) {
        try (var is = getClass().getClassLoader().getResourceAsStream("prompts/" + file)) {
            if (is == null) {
                return "";
            }
            byte[] data = is.readAllBytes();
            // simple backup mechanism
            java.nio.file.Files.write(java.nio.file.Paths.get("src/main/resources/prompts/backup/" + file), data,
                    java.nio.file.StandardOpenOption.CREATE,
                    java.nio.file.StandardOpenOption.TRUNCATE_EXISTING);
            return new String(data);
        } catch (Exception e) {
            return "";
        }
    }

    @Bean
    public CommandLineRunner runner(JobService jobs) {
        return args -> {
            jobs.schedule(JobType.PLAN_TASK, "plan");
            jobs.schedule(JobType.NUDGE, "nudge");
            jobs.schedule(JobType.VERIFY, "verify");
            jobs.schedule(JobType.REWARD, "reward");
            for (int i = 0; i < 4; i++) {
                jobs.runOnce();
            }
        };
    }

	public static void main(String[] args) {
		SpringApplication.run(ExecutiveBrainApplication.class, args);
	}

}
