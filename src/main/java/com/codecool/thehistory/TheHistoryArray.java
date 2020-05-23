package com.codecool.thehistory;


import java.lang.reflect.Array;
import java.util.Arrays;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information

        String[] thaAdd = text.split("\\s+");

        String[] copyOfWordsArray = new String[wordsArray.length];
        System.arraycopy(wordsArray, 0, copyOfWordsArray, 0, copyOfWordsArray.length);

        wordsArray = new String[thaAdd.length + wordsArray.length];
        System.arraycopy(copyOfWordsArray, 0, wordsArray, 0, copyOfWordsArray.length);
        System.arraycopy(thaAdd, 0, wordsArray, wordsArray.length - thaAdd.length, thaAdd.length);
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information

     String newWordsArrayString = this.toString().replaceAll(wordToBeRemoved, "").trim();
     String [] newWordsArray = newWordsArrayString.split("\\s+");
     wordsArray = new String[newWordsArray.length];
     wordsArray = newWordsArrayString.split("\\s+");

    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(from)) {
                wordsArray[i] = to;
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information



    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }
}
