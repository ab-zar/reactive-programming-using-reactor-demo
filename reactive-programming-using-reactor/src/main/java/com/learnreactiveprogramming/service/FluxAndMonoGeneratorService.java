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

    @SuppressWarnings("ReactiveStreamsUnusedPublisher")
    public Flux<String> wordsFluxImmutability() {
        var wordsFlux = Flux.fromIterable(List.of("gyros", "echpochmak", "chicken", "cookies", "balesh"));

        wordsFlux.map(String::toUpperCase);

        return wordsFlux;
    }

    public Mono<String> nameMonoMapFilter(int stringLength) {
        return Mono.just("alex").map(String::toUpperCase).filter(name -> name.length() > stringLength);
    }

    public Flux<String> wordsFluxFlatMap(int stringLength) {
        // might be coming from a db or a service call
        return Flux.fromIterable(List.of("tea", "burrito", "pie", "doughnut", "cookie"))
                //Map to upper case
                .map(String::toUpperCase)
                //filter out words with length < 4
                .filter(s -> s.length() > stringLength)
                // flat map: BURRITO -> B U R R I T O
                .flatMap(s -> splitString(s))
                .log();
    }

    public Flux<String> splitString(String str) {
        var charArray = str.split("");
        return Flux.fromArray(charArray);
    }


    public static void main(String[] args) {
        FluxAndMonoGeneratorService service = new FluxAndMonoGeneratorService();
        service.wordsFlux().subscribe(word -> System.out.println("Flux. The dish is : " + word));

        service.wordMono().subscribe(word -> System.out.println("Mono. The dish is : " + word));

        service.wordsFluxImmutability().subscribe(System.out::println);

        service.wordsFluxFilter(3).subscribe(word -> System.out.println("Flux. word length > 3. The word is: " + word));

        service.nameMonoMapFilter(3).subscribe(System.out::println);
    }
}
