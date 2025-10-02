package com.milton.producerservice.gateway.impl;

//import com.milton.producerservice.gateway.AuthServerGateway;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//@Component
//@Slf4j
//public class AuthServerGatewayImpl implements AuthServerGateway {
//
//    private final WebClient webClient;
//
//    public AuthServerGatewayImpl(WebClient webClient) {
//        this.webClient = webClient;
//    }
//
//    @Override
//    public Mono<Health> getHealth() {
//        return webClient.get()
//            .uri("http://localhost:9000/actuator/health")
//            .retrieve()
//            .bodyToMono(String.class)
//            .map(response -> Health.up().withDetail("Authentication Server", response).build())
//            .onErrorResume(ex -> Mono.just(Health.down(ex).build()));
//    }
//}