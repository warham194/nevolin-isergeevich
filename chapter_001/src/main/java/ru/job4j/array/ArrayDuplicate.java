package ru.job4j.array;

import java.util.Arrays;

/**
 * Class BubbleSort.
 * @author Ilya.
 * @since  2017.10.
 */
public class ArrayDuplicate {
    /**
     * method for sort array to the end and delete double.
     *@param array String [] values
     *@return Arrays.copyOf.
     */
    public String[] remove(String[] array) {

        int dup = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - dup; j++) {
                if (array[i].equals(array[j])) {
                    while (j < array.length - dup - 1 && array[array.length - dup - 1].equals(array[j])) {
                        dup++;
                    }
                    String tmp = array[array.length - dup - 1];
                    array[array.length - dup - 1] = array[j];
                    array[j] = tmp;
                    dup++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - dup);
    }

//    [6, 7, 8, 8, 4, 8, 4, 5, 6, 4, 7, 7, 6, 6]
    //[6, 7, 8, 4, 5, 4, 4, 8, 8, 7, 7, 6, 6, 6]
//dup = 4
}