package ru.job4j.loop;


public class Factorial {

private int result;
    public int calc(int n) {

        for (int i = 0; i <= n ; i ++){
            if (i == 0){
                result = 1;
            }
            result = result*i;
        }

        return  result;
    }

}