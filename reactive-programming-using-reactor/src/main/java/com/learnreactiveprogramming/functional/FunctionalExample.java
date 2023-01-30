package com.learnreactiveprogramming.functional;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalExample {
    public static void main(String[] args) {
        var wordList = List.of("beef", "chicken", "pea", "tea", "buckwheat", "potato", "potato");
        var filteredWords = wordsLongerThanSizeNoDuplicatesToUpperCase(wordList, 3);
        System.out.println(filteredWords);

    }

    private static List<String> wordsLongerThanSizeNoDuplicatesToUpperCase(List<String> wordList, int i) {
        return wordList.stream().filter(word -> word.length() > i).map(String::toUpperCase).distinct().collect(Collectors.toList());
    }
}
