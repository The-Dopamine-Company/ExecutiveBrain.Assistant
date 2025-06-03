Project Bootstrapping & Prototyping Guide
Clone project
git clone ... && cd digital-exec-brain

Initialize folders

sh
Copy
Edit
mkdir -p src/main/java/com/assistant/{agents,comms,tasks,context,tracking}
mkdir -p resources/prompts
Install dependencies

Spring Boot: web, data-jpa, test, actuator

Twilio/WhatsApp API SDK

OpenAI/Gemini API SDK

Create minimal agent graph

Implement base Agent class.

Add minimal agent types (Planner, Nudge, Monitor, Evolver).

Setup agent registry in Main.

Stub Communication Interface

sendText(), sendCall(), receive()

Implement Job/Task loop

Jobs scheduled by Planner, executed by comms, tracked by Monitor, evolved by Evolver.

Setup context & feedback

Mock context/user input for early dev.

Stub Feedback and Rewarder.

Add system prompt files

Store one .md file per agent in resources/prompts/.

Add a versioning/backup mechanism.

Manual test: Plan → Nudge → Progress → Reward

Log everything.

Tune prompts, test reward loop.

Iterate!

Add agent evolution, context sensors, richer communication tools.

Refactor as graph grows.
