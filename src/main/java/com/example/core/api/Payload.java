package com.example.core.api;

import java.time.Instant;

/**
 * Payload
 */
public record Payload( 
    String service,
    String status,
    Instant timestamp,
    String message
) {

}
