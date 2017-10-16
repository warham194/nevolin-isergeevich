package ru.job4j.array;
/**
 * Class BubbleSort.
 * @author Ilya.
 * @since  2017.10.
 */



public class BubbleSort{
    /**
     * Method add.
     * @param array args.
     * @return array.
     */
    public int[] sort(int[] array){
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i;j++){
                if (array[j] > array[j+1]){
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
            }
        }

        return array;
    }

}