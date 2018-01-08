package ru.ilya.start;

/**
 * Created by Lenovo2 on 20.11.2017.
 */
public class StubInput implements Input {
    private String[] answers ;
    private int position = 0;
    public StubInput(String[] answers){
        this.answers = answers;
    }

    public String ask(String question) {
        return answers[position++];
    }

    public int ask(String question, int[] range){
        return Integer.parseInt(answers[position++]);// вопрос
    }
}
