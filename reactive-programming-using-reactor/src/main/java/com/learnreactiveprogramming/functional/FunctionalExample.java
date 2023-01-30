package com.learnreactiveprogramming.functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalExample {
    public static void main(String[] args) {
        var wordList = List.of("beef", "chicken", "pea", "tea", "buckwheat", "potato", "potato");
        var filteredWords = wordsLongerThanSize(wordList, 4);
        System.out.println(filteredWords);

    }

    private static List<String> wordsLongerThanSize(List<String> wordList, int i) {
        return wordList.stream().filter(word -> word.length() > 3).collect(Collectors.toList());
    }
}
