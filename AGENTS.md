Digital Executive Brain – Agent System Specification
Vision:
A modular, evolving graph of LLM-powered agents, acting as an autonomous executive brain—planning, initiating, and tracking real progress on user goals and tasks, adapting strategies and communication methods dynamically to maximize actual outcomes.

1. Agent Graph Architecture
Agent = LLM-powered module with a dedicated function and system prompt.

Graph = dynamic network: agents call each other, share context, and co-own the user’s progress loop.

**All agents communicate by scheduling “jobs” (interventions), tracking feedback, and evolving their strategy/prompt via RL or meta-LLM.

2. Agent Types & Roles
AgentType	Role/Responsibility
Planner	Break down goals, schedule atomic tasks, and re-plan adaptively
Nudge	Decide how, when, and with what tone to nudge/initiate action
Monitor	Verify actual task progress (not just user replies)
Evolver	Summarize logs, evolve agent prompts, spawn new agents
Triage	Route user-initiated comms (text/call) to the right agent
Distraction	Detect off-task behavior, intervene as needed
Rewarder	Assign RL reward for progress/completion

3. Agent Class Template
java
Copy
Edit
public class Agent {
    private AgentType type;
    private String systemPrompt;
    private float lastRewardScore;
    private List<PromptVersion> evolutionHistory;
    private List<LLMToolCall> toolCallHistory;

    public Decision decideStrategy(Task task, UserContext ctx) { /* LLM call */ }
    public void evolvePrompt(Feedback feedback) { /* meta-LLM call */ }
    public Agent spawnChildAgent(String role, String prompt) { /* meta-agent logic */ }
    public LLMToolCall callTool(String toolName, String input) { /* tool API */ }
}
SystemPrompt: Each agent’s “personality” and logic; lives in resources/prompts/.

evolutionHistory: Stores all changes for transparency.

All core decisions use LLMs for maximum adaptation and autonomy.

4. Job/Communication System
CommunicationJob: Represents every action (call, text, internal check) the agent system schedules.

Owned by an agent, with a clear JobType (TaskInit, Nudge, PlanApproval, etc.)

Specifies channel (text/call), timing, and purpose.

CommunicationInterface: Abstraction for sending/receiving all comms; implements text/call (e.g. Twilio, WhatsApp).

Agents schedule jobs autonomously and can reassign/cancel as strategies evolve.

5. Context, Feedback, and Reward
UserContext: Real-time data—location, calendar, app usage, stress, preferences.

Feedback: Every job receives explicit reward based on actual progress (task started, completed, or not).

Rewarder Agent: Updates agent strategies using RL (e.g. Q-learning).

6. Prompt Evolution and New Agent Creation
Evolver agent periodically reviews feedback and performance, triggering:

Prompt rewrites for struggling agents (LLM-generated).

New agent spawning for uncovered behavioral patterns (e.g. "Gym Initiation Agent" if user adopts new habit).

All prompt changes/versioning is logged.

7. Autonomous Scheduling
Agents manage their own schedules and the system’s overall “wakeup” cycle—no dependence on external triggers or OS-level cron jobs.

E.g., Planner agent can schedule check-ins for later, Nudge agent can retry after delays, Evolver agent can schedule periodic self-review.

8. Minimal Agent Graph for MVP
Planner (break down goals, make plans, schedule jobs)

Nudge (initiate/nudge/alert via call/text)

Monitor (track actual progress)

Evolver (refine prompts, add new agent roles as needed)

Rewarder (assign rewards/penalties to strategies and prompts)

9. Key Class/File Summary
Class/File	Purpose
Agent, AgentType, PromptVersion	Core agent logic, prompt management
Planner, Nudge, Monitor, Evolver	Specialized agent types
CommunicationInterface, CommunicationJob, JobType	Communication abstraction, scheduling interventions
Task, Goal, Feedback	User’s work and RL reward loop
UserContext	Real-time context for all agents
Main	Master scheduler, system boot

10. Prototyping Steps
Implement core Agent class and registry/graph manager

Stub out Planner, Nudge, Monitor, Evolver, Rewarder agents

Build CommunicationInterface and CommunicationJob system

Wire minimal “progress loop” (plan > nudge > verify > reward)

Add UserContext stubs (manual/mock initially)

Implement simple RL (Q-table) for agent strategy selection

Add prompt evolution (manually or meta-LLM for now)

Deploy, log all actions, and observe system reward curve

11. Design Philosophies
Onus is on the assistant, not the user: The agent graph drives all progress loops.

Every method is an agent + LLM call: No hardcoded logic—adapt, evolve, and self-improve.

Autonomous scheduling and self-evolution: The agent system manages all jobs, strategies, and even its own topology.

Reward = real progress: RL ensures agent adaptation is driven by your actual outcomes, not surface-level compliance.

12. Extending
Add new agent types as new needs emerge (motivation, distraction, habit, self-reflection).

Integrate more sensors/contexts for richer adaptation.

Switch RL/LLM “meta-agent” to full automation as confidence grows.
