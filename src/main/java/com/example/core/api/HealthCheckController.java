package com.example.core.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController 
@RequestMapping("api/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<Payload> getMethodName() {
        return ResponseEntity.ok(
            new Payload(
                "core-api", 
                "healthy", 
                Instant.now(), 
                "CI/CD pipeline successful"
            )
        );
    }
    

}
