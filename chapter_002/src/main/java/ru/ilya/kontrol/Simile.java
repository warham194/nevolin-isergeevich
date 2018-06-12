package ru.ilya.kontrol;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Lenovo2 on 25.05.2018.
 */
public class Simile {
    public boolean comWords(String firstWord, String secondWord) {
        boolean result = firstWord.length() == secondWord.length();
            char[] chArrayOne = firstWord.toCharArray();
            char[] chArrayTwo = secondWord.toCharArray();
            Arrays.sort(chArrayOne);
            Arrays.sort(chArrayTwo);
            for (int i = 0; i < chArrayOne.length; i++) {
                if (chArrayOne[i] != chArrayTwo[i]) {
                    result = false;
                    break;
                }
            }
        return result;
    }

}
