package ru.job4j.array;
/**
 * Class BubbleSort.
 * @author Ilya.
 * @since  2017.10.
 */
import java.util.Arrays;


public class ArrayDuplicate{
    public String[] remove(String[] array){
        int dup = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j =i+1; j < array.length - dup ;j++){
                if (array[i].equals(array[j])){
                    while (j != array.length -dup -1 && array[array.length - dup -1].equals(array[j])){
                        dup++;
                    }
                    String tmp = array[array.length - dup -1];
                    array[array.length - dup -1] = array[j];
                    array[j] = tmp;
                    dup++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - dup);
    }



}