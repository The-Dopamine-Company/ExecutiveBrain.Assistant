package com.assistant.tracking;

public class Feedback {
    private final boolean completed;

    public Feedback(boolean completed) {
        this.completed = completed;
    }

    public boolean isCompleted() {
        return completed;
    }
}
