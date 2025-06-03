package com.assistant.comms;

import java.time.Instant;

public class CommunicationJob {
    private final JobType type;
    private final Instant scheduled;
    private final String payload;

    public CommunicationJob(JobType type, Instant scheduled, String payload) {
        this.type = type;
        this.scheduled = scheduled;
        this.payload = payload;
    }

    public JobType getType() {
        return type;
    }

    public Instant getScheduled() {
        return scheduled;
    }

    public String getPayload() {
        return payload;
    }
}
