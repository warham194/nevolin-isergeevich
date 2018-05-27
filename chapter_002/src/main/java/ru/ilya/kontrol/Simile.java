package ru.ilya.kontrol;

import java.util.ArrayList;

/**
 * Created by Lenovo2 on 25.05.2018.
 */
public class Simile {
    public boolean comWords(String firstWord, String secondWord) {
        boolean result = firstWord.length() == secondWord.length();
            char[] chArrayOne = firstWord.toCharArray();
            char[] chArrayTwo = secondWord.toCharArray();
            for (Character i : chArrayOne) {
                for (int j = 0; j < chArrayTwo.length; j++) {
                    if (i.equals(chArrayTwo[j])) {
                        chArrayTwo[j] = ' ';
                        break;
                    }
                }
            }
            for (Character a : chArrayTwo) {
                if (a != ' ') {
                    result = false;
                    break;
                }
            }
        return result;
    }
}
