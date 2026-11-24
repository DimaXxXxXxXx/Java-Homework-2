package org.example;

import java.time.Duration;
import java.time.Instant;

public record Incident(
        String id,
        String service,
        Instant startedAt,
        Instant resolveAt) {
    public Incident(){
        if(id == null){
            throw new IllegalArgumentException("Id не может быть пустым.");
        }
        if(service == null){
            throw new IllegalArgumentException("Service не может быть пустым.");
        }
        if (resolveAt.isBefore(startedAt())){
            throw new IllegalArgumentException("Момент начале не может быть раньше завершения.");
        }
    }

    public Duration duration() {
        return Duration.between(startedAt, resolveAt);
    }
}
