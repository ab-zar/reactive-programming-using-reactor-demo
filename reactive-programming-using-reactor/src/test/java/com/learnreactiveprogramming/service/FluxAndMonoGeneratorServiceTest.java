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
    void testNameMono_map_filter() {
        //given
        //when
        var nameMono = fluxAndMonoGeneratorService.nameMono_map_filter(3);

        //then
        StepVerifier.create(nameMono)
                .expectNext("ALEX")
                .verifyComplete();

        //when
        var nameMonoEmpty = fluxAndMonoGeneratorService.nameMono_map_filter(4);


        //then
        StepVerifier.create(nameMonoEmpty)
                .expectNextCount(0)
                .verifyComplete();

    }
}
