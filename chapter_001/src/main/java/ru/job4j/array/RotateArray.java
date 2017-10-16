package ru.job4j.array;
/**
 * Class BubbleSort.
 * @author Ilya.
 * @since  2017.10.
 */



public class RotateArray{
    /**
     * Method add.
     * @param array args.
     * @return array.
     */
    public int[][] rotate(int[][] array){
        int[][] massiv = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                 massiv [j][array.length - i - 1] = array[i][j];
            }

        }
        return  massiv;
    }

}