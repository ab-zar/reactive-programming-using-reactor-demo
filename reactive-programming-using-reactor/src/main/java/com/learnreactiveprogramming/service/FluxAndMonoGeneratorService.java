package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> wordsFlux() {
        // might be coming from a db or a service call
        return Flux.fromIterable(List.of("pizza", "burrito", "brownie", "doughnut", "pie")).log();
    }

    public Mono<String> wordMono() {
        return Mono.just("kebab").log();
    }

    public Flux<String> wordsFluxMap() {
        // might be coming from a db or a service call
        return Flux.fromIterable(List.of("pizza", "burrito", "brownie", "doughnut", "pie"))
                .map(String::toUpperCase)
                .log();
    }


    public static void main(String[] args) {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        service.wordsFlux().subscribe(name -> {
            System.out.println("Flux. The dish is : " + name);
        });

        service.wordMono().subscribe(word -> System.out.println("Mono. The dish is : " + word));
    }
}
