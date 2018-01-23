package ru.job4j.array;

/**
 * Created by Lenovo2 on 21.10.2017.
 */
public class ProverkaSlova {
    /**
     * method for sort array to the end and delete double.
     * @param origin args
     * @param origin args
     *@return result.
     */
    public boolean contains(String origin, String sub) {
        boolean is = false;

        char[] first = origin.toCharArray();
        char[] second = sub.toCharArray();
        for (int i = 0; i < first.length - second.length; i++) {
            if (first[i] == second[0]) {
                for (int j = 1; j < second.length; j++) {
                    if (first[i + j] == second[j]) {
                        is = true;
                    }
                    else {
                        is = false;
                        break;
                    }
                    if (is)  break;
                }
            }
    }
        return is;
  }
}
