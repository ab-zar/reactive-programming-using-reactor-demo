package com.learnreactiveprogramming.imperative;

import java.util.ArrayList;
import java.util.List;

public class ImperativeExample {

    public static void main(String[] args) {
        var wordList = List.of("beef", "chicken", "pea", "tea", "buckwheat", "potato", "potato");
        var filteredWords = wordsLongerThanSizeNoDuplicates(wordList, 4);
        System.out.println(filteredWords);
    }

    private static List<String> wordsLongerThanSizeNoDuplicates(List<String> wordList, int i) {
        var filteredWordList = new ArrayList<String>(wordList.size());

        for (String word : wordList) {
            if (word.length() > i && !filteredWordList.contains(word)) {
                filteredWordList.add(word);
            }
        }
        return filteredWordList;
    }
}
