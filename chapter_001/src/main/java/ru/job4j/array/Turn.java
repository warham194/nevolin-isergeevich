package ru.job4j.array;
/**
 * Class Turn.
 * @author Ilya.
 * @since  2017.10.
 */
public class Turn {
    /**
     * Method add.
     * @param array args.
     * @return array
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
        return array;
    }
                   // 4, 1, 6, 2
}                  // 2, 6, 1, 4
