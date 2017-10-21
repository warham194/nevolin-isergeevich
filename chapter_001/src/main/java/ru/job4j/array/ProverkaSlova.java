package ru.job4j.array;

/**
 * Created by Lenovo2 on 21.10.2017.
 */
public class ProverkaSlova {
    public boolean contains(String origin, String sub){
        boolean result = false;

        char[] slovo1 = origin.toCharArray();
        char[] slovo2 = sub.toCharArray();
            for (int i = 0; i < slovo1.length; i++){
                for (int j = 0; j < slovo2.length; j++){
                    if (slovo2[j] == slovo1[i] && ...........){
                        result = true;

                    }
                }
            }

       return result;
    }
}
