package com.codecool.thehistory;

import java.lang.reflect.Array;
import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information

        String[] arrayText = text.trim().split("\\s+");

        for (String word: arrayText) {
            wordsLinkedList.add(word);
        }
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information

        wordsLinkedList.removeIf(word -> word.equals(wordToBeRemoved));
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
//        Iterator<String> iter = wordsLinkedList.iterator();
//
//        int currElementIndex = -1;
//        while(iter.hasNext()) {
//            currElementIndex += 1;
//            String str = iter.next();
//            if (str.equals(from)) {
//                wordsLinkedList.set(currElementIndex, to);
//            }
//        }

        Collections.replaceAll(wordsLinkedList, from, to);
    }

    public String stringBuilder(String[] collectionToConvert) {

        StringBuilder collectionWordsStr = new StringBuilder();
        for (String word: collectionToConvert) {
            collectionWordsStr.append(word).append(" ");
        }
        if (collectionWordsStr.length() > 0) collectionWordsStr.deleteCharAt(collectionWordsStr.length() - 1);

        String theString = collectionWordsStr.toString();
        return theString;
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information

        StringBuilder collectionWordsSb = new StringBuilder();
        for (String word: wordsLinkedList) {
            collectionWordsSb.append(word).append(" ");
        }
        if (collectionWordsSb.length() > 0) collectionWordsSb.deleteCharAt(collectionWordsSb.length() - 1);

        String collectionWordsStr = collectionWordsSb.toString();

        String fromWordsStr = stringBuilder(fromWords);
        String toWordsStr = stringBuilder(toWords);

        collectionWordsStr = collectionWordsStr.replace(fromWordsStr, toWordsStr);

        wordsLinkedList = Arrays.asList(collectionWordsStr.split(" "));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
