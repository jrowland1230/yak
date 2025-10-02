package com.milton.producerservice.gateway;

import org.springframework.boot.actuate.health.Health;
import reactor.core.publisher.Mono;

public interface AuthServerGateway {
    Mono<Health> getHealth();
}
