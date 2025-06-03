package com.assistant.comms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CommunicationInterface {
    private static final Logger log = LoggerFactory.getLogger(CommunicationInterface.class);

    public void sendText(String message) {
        log.info("[TEXT] {}", message);
    }

    public void sendCall(String message) {
        log.info("[CALL] {}", message);
    }

    public String receive() {
        log.info("Receiving message (stub)");
        return "OK";
    }
}
