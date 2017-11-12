package ru.ilya.start;

import java.util.Scanner;

/**
 * Created by Lenovo2 on 10.11.2017.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question){
        System.out.println(question);
        return scanner.next();
    }
}
