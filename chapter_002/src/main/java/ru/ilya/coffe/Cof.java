package ru.ilya.coffe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo2 on 19.01.2018.
 */
public class Cof {


    public List<Integer> changes(int value, int price) {

        int[] coins = {1, 2, 5, 10, 50, 100};
        int sdacha = value - price;
        List<Integer> result = new ArrayList<Integer>();
        while (sdacha != 0) {

            for (int i = coins.length - 1; i >= 0; i--) {
                if (coins[i] <= sdacha) {
                    sdacha = sdacha - coins[i];
                    System.out.println("Monetka " + coins[i]);
                    result.add(coins[i]);
                    i++;
                }

            }
        }
        return result;

    }

}
