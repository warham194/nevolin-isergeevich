package ru.ilya.start;

import java.util.ArrayList;

/**
 * Created by Lenovo2 on 10.11.2017.
 */
public interface Input {
    String ask(String question);

    int ask(String question, ArrayList<Integer> range);
}
