package com.learnreactiveprogramming.service;

import reactor.core.publisher.Flux;

import java.util.List;

public class FluxAndMonoGeneratorService {

    public Flux<String> wordsFlux() {
        // might be coming from a db or a service call
        return Flux.fromIterable(List.of("pizza", "burrito", "brownie", "doughnut", "pie"));
    }


    public static void main(String[] args) {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        service.wordsFlux().subscribe(name -> {
            System.out.println("Dish is : " + name);
        });
    }
}
