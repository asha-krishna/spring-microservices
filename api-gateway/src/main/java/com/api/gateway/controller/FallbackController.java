package com.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/productFallBack")
    public Mono<String> productFallBack() {
        return Mono.just("product-service is not responding or under maintenance. Please try again");
    }

    @RequestMapping("/pricingFallBack")
    public Mono<String> pricingFallBack() {
        return Mono.just("pricing-service is not responding or under maintenance. Please try again");
    }

    @RequestMapping("/inventoryFallBack")
    public Mono<String> inventoryFallBack() {
        return Mono.just("inventory-service is not responding or under maintenance. Please try again");
    }
}
