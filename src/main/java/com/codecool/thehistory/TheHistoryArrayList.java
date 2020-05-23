package com.codecool.thehistory;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList=new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information

        String noSpaces=text.trim().replaceAll("\\s+", " ");

        String[] arrayText=noSpaces.split("\\s");

        for (String word : arrayText) {
            wordsArrayList.add(word);
        }
    }


    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information

        wordsArrayList.removeIf(word -> word.equals(wordToBeRemoved));

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information

//        for (int i = 0; i < wordsArrayList.size(); i++) {
//            if (wordsArrayList.get(i).equals(from)) {
//                wordsArrayList.set(i, to);
//            }
//        }
        Collections.replaceAll(wordsArrayList, from, to);

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

//        int wordsToMatch = fromWords.length;
//        String firstWordToMatch = fromWords[0];
//
//        List<Integer> possibleMatches = new ArrayList<>();
//        List<Integer> certainMatches = new ArrayList<>();
//
//        for(int i = 0; i < wordsArrayList.size(); i++) {
//            if (wordsArrayList.get(i).equals(firstWordToMatch)) {
//                possibleMatches.add(i);
//            }
//        }
//
//
//        for(int j = 0; j < possibleMatches.size(); j++) {
//            int matchesCount = 1;
//            if (matchesCount == fromWords.length) {
//                certainMatches.add(possibleMatches.get(j));
//            }
//            for(int k = 1; k < wordsToMatch; k++) {
//                if (wordsArrayList.size() > possibleMatches.get(j) + k) {
//                    if (wordsArrayList.get(possibleMatches.get(j) + k).matches(fromWords[k])) {
//                        matchesCount+=1;
//                        if (matchesCount == fromWords.length) {
//                            certainMatches.add(possibleMatches.get(j));
//                        }
//                    }
//                }
//            }
//        }
//
//
//        for(int l = certainMatches.size() - 1; l >= 0; l--) {
//            for(int x = 0; x < wordsToMatch; x++) {
//                wordsArrayList.remove((int) certainMatches.get(l));
//            }
//        }
//
//
//        for (int n = 0; n < certainMatches.size(); n++) {
//            for(int m = toWords.length - 1; m >= 0; m--) {
//                if (certainMatches.get(n) > 0)
//                    wordsArrayList.add((certainMatches.get(n) - fromWords.length + toWords.length), toWords[m]);
//                else {
//                    wordsArrayList.add(certainMatches.get(n), toWords[m]);
//                }
//            }
//        }

        StringBuilder collectionWordsSb = new StringBuilder();
        for (String word: wordsArrayList) {
            collectionWordsSb.append(word).append(" ");
        }
        if (collectionWordsSb.length() > 0) collectionWordsSb.deleteCharAt(collectionWordsSb.length() - 1);

        String collectionWordsStr = collectionWordsSb.toString();

        String fromWordsStr = stringBuilder(fromWords);
        String toWordsStr = stringBuilder(toWords);

        collectionWordsStr = collectionWordsStr.replace(fromWordsStr, toWordsStr);

        wordsArrayList = Arrays.asList(collectionWordsStr.split(" "));

    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
