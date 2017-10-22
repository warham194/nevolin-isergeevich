package ru.job4j.array;

/**
 * Created by Lenovo2 on 22.10.2017.
 */
public class Sortirovka {
    /**
     * Method insertSort.
     * @param a args.
     * @param b args.
     * @return result.
     */
    public int[] insertSort (int[] a, int[] b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);



        // проведем сортировку вставками
        int temp, j;
        for(int i = 0; i < result.length - 1; i++){
            if (result[i] > result[i + 1]) {
                temp = result[i + 1];
                result[i + 1] = result[i];
                j = i;
                while (j > 0 && temp < result[j - 1]) {
                    result[j] = result[j - 1];
                    j--;
                }
                result [j] = temp;
            }
        }

        return result;
    }

}
