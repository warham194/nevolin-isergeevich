package ru.job4j.array;

/**
 * Created by Lenovo2 on 22.10.2017.
 */
public class Sortirovka {
    /**
     * Method insertSort.
     * @param a1 args.
     * @param a2 args.
     * @return a3.
     */
    public int[] insertSort(int[] a1, int[] a2) {
        if (a1 == null) {
            return a2;
        }
        if (a2 == null) {
            return a1;
        }
        int[] a3 = new int[a1.length + a2.length];

        int i = 0, j = 0;
        for (int k = 0; k < a3.length; k++) {

            if (i > a1.length - 1) {
                int a = a2[j];
                a3[k] = a;
                j++;}

            else if (j > a2.length - 1) {
                int a = a1[i];
                a3[k] = a;
                i++;
            }
            else if (a1[i] < a2[j]) {
                int a = a1[i];
                a3[k] = a;
                i++;
            }
            else {
                int b = a2[j];
                a3[k] = b;
                j++;
            }
        }

        return a3;
    }

}
