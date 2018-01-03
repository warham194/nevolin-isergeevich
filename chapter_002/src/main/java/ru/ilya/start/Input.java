package ru.ilya.start;

/**
 * Created by Lenovo2 on 10.11.2017.
 */
public interface Input {
    String ask(String question);

    int ask(String question, int[] range);
}
