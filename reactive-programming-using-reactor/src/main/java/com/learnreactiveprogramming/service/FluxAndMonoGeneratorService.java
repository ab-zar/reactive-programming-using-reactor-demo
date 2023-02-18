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

    public Flux<String> wordsFluxFilter(int strLen) {
        // might be coming from a db or a service call
        //filtering words with length > 3
        return Flux.fromIterable(List.of("tea", "burrito", "pie", "doughnut", "cookie"))
                .filter(word -> word.length() > strLen)
                .map(word -> word.length() + "-" + word)
                .log();
    }

    public Flux<String> wordsFlux_immutability() {
        var wordsFlux = Flux.fromIterable(List.of("gyros", "echpochmak", "chicken", "cookies", "balesh"));

        wordsFlux.map(String::toUpperCase);

        return wordsFlux;
    }

    public Mono<String> nameMono_map_filter(int stringLength) {
        return Mono.just("alex").map(String::toUpperCase).filter(name -> name.length() > stringLength);
    }


    public static void main(String[] args) {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        service.wordsFlux().subscribe(word -> System.out.println("Flux. The dish is : " + word));

        service.wordMono().subscribe(word -> System.out.println("Mono. The dish is : " + word));

        service.wordsFlux_immutability().subscribe(System.out::println);

        service.wordsFluxFilter(3).subscribe(word -> System.out.println("Flux. word length > 3. The word is: " + word));
    }
}
