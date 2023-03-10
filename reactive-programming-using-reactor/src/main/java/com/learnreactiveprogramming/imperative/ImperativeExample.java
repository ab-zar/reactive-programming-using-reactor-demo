package com.learnreactiveprogramming.imperative;

import java.util.ArrayList;
import java.util.List;

public class ImperativeExample {

    public static void main(String[] args) {
        var wordList = List.of("beef", "chicken", "pea", "tea", "buckwheat", "potato", "potato");
        var filteredWords = wordsLongerThanSizeNoDuplicatesToUpperCase(wordList, 3);
        System.out.println(filteredWords);
    }

    private static List<String> wordsLongerThanSizeNoDuplicatesToUpperCase(List<String> wordList, int i) {
        var filteredWordList = new ArrayList<String>(wordList.size());

        for (String word : wordList) {
            if (word.length() > i && !filteredWordList.contains(word.toUpperCase())) {
                filteredWordList.add(word.toUpperCase());
            }
        }
        return filteredWordList;
    }
}
