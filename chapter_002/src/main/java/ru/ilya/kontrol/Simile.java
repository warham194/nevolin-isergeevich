package ru.ilya.kontrol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lenovo2 on 25.05.2018.
 */
public class Simile {
    public boolean comWords(String firstWord, String secondWord) {
        boolean result = firstWord.length() == secondWord.length();
        /* Первый способ
            char[] chArrayOne = firstWord.toCharArray();
            char[] chArrayTwo = secondWord.toCharArray();
            Arrays.sort(chArrayOne);
            Arrays.sort(chArrayTwo);
            if(!Arrays.equals(chArrayOne, chArrayTwo)) {
              result = false;
            }
            */
        // Второй способ
        char[] chArrayOne = firstWord.toCharArray();
        char[] chArrayTwo = secondWord.toCharArray();
        Map<Character, Integer> anagram = new HashMap<>();
        for (Character c : chArrayOne) {
            int count = 1;
            if (anagram.containsKey(c)) {
                count = anagram.get(c) + 1;
            }
            anagram.put(c, count);
        }
        for (Character c : chArrayTwo) {
            int count = - 1;
            if (anagram.containsKey(c)) {
                count = anagram.get(c) - 1;
            }
            anagram.put(c, count);
        }

        for (Character c : anagram.keySet()) {
            if (anagram.get(c) != 0) {
                result = false;
                break;
            }
        }
        return result;
    }

}
