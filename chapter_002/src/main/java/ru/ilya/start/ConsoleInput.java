package ru.ilya.start;

import java.util.Scanner;
import java.util.ArrayList;
/**
 * Created by Lenovo2 on 10.11.2017.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.println(question);
        return scanner.next();
    }

    public int ask(String question, ArrayList<Integer> range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for(int value : range) {
            if(value == key) {
                exist = true;
                break;
            }
        }
        if(exist){

            return key;
        } else{

            throw new MenuOutExeption("Некорректный ввод");
        }

    }
}
