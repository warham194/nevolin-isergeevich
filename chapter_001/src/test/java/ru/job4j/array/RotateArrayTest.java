package ru.job4j.array;
/**
 * Test.
 *
 * @author Ilya
 * @since  2017.10.
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    /**
     * @Test rotate.
     */
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
        RotateArray sor = new RotateArray();
        int[][] array1 = {{1,2},{3,4}};
        int[][] rezultTest = {{3,1},{4,2}};
        int[][] result = sor.rotate(array1);
        assertThat(result, is(rezultTest));
    }

    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 3 на 3.
        RotateArray sor = new RotateArray();
        int[][] array1 = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] rezultTest = {{7,4,1},{8,5,2},{9,6,3}};
        int[][] result = sor.rotate(array1);
        assertThat(result, is(rezultTest));
    }
}