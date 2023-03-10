package com.learnreactiveprogramming.service;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class FluxAndMonoGeneratorServiceTest {
    FluxAndMonoGeneratorService fluxAndMonoGeneratorService = new FluxAndMonoGeneratorService();

    @Test
    void testFlux() {
        //given
        //when
        var wordsFlux = fluxAndMonoGeneratorService.wordsFlux();
        //then
        StepVerifier.create(wordsFlux)
                .expectNext("pizza", "burrito")
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void testMono() {
        //when
        var wordMono = fluxAndMonoGeneratorService.wordMono();
        //then
        StepVerifier.create(wordMono)
                .expectNext("kebab")
                .verifyComplete();
    }

    @Test
    void testFluxMap() {
        //when
        var wordsFlux = fluxAndMonoGeneratorService.wordsFluxMap();
        //then
        StepVerifier.create(wordsFlux)
                .expectNext("PIZZA", "BURRITO", "BROWNIE", "DOUGHNUT", "PIE")
                .verifyComplete();
    }

    @Test
    void testWordsFluxImmutability() {
        //given
        //when
        var wordsFlux = fluxAndMonoGeneratorService.wordsFluxImmutability();

        //then
        StepVerifier.create(wordsFlux)
                .expectNext("gyros", "echpochmak")
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void testWordFluxFilter() {
        //given

        //when
        var wordsFlux = fluxAndMonoGeneratorService.wordsFluxFilter(3);

        //then
        StepVerifier.create(wordsFlux)
                .expectNext("7-burrito")
                .expectNextCount(2)
                .verifyComplete();
    }

    @Test
    void testNameMonoMapFilter() {
        //given
        //when
        var nameMono = fluxAndMonoGeneratorService.nameMonoMapFilter(3);

        //then
        StepVerifier.create(nameMono)
                .expectNext("ALEX")
                .verifyComplete();

        //when
        var nameMonoEmpty = fluxAndMonoGeneratorService.nameMonoMapFilter(4);


        //then
        StepVerifier.create(nameMonoEmpty)
                .expectNextCount(0)
                .verifyComplete();

    }

    @Test
    void testWordFluxFlatMap() {
        //given
        var stringLength = 3;

        //when
        var charFlux = fluxAndMonoGeneratorService.wordsFluxFlatMap(stringLength);

        //then
        StepVerifier.create(charFlux)
                .expectNext("B", "U", "R", "R", "I", "T", "O")
                .expectNextCount("doughnut".length() + "cookie".length())
                .verifyComplete();


    }

    @Test
    void testWordFluxFlatMapAsync() {
        //given
        var stringLength = 3;

        //when
        var charFlux = fluxAndMonoGeneratorService.wordsFluxFlatMapAsync(stringLength);

        //then
        StepVerifier.create(charFlux)
                .expectNextCount("burrito".length() + "doughnut".length() + "cookie".length())
                .verifyComplete();
    }

}
