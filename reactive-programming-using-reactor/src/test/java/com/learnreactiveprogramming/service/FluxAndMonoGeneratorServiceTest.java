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
    void testWordsFlux_immutability() {
        //given
        //when
        var wordsFlux = fluxAndMonoGeneratorService.wordsFlux_immutability();

        //then
        StepVerifier.create(wordsFlux)
                .expectNext("gyros", "echpochmak")
                .expectNextCount(3)
                .verifyComplete();
    }
}
