package ru.ilya.coffe;

import java.util.Arrays;

/**
 * Created by Lenovo2 on 19.01.2018.
 */
public class Cof {


    public int[] changes(int value, int price){
        int [] result = new int[10];
        int[] coins = {1, 2, 5, 10, 50, 100};
        int sdacha = value - price;

        while (sdacha != 0){
            for (int i = coins.length - 1; i >= 0; i--){
                if (coins[i] <= sdacha){
                    sdacha = sdacha - coins[i];
                    System.out.println("Monetka " +coins[i]);
                    i++;
                    result[i] = coins[i];
                }
            }
        }
      return result;

    }

}
