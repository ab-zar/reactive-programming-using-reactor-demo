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
}
