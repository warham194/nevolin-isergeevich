/**
 * Test.
 *
 * @author Ilya
 * @since  2017.10.
 */
package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BubbleSortTest {
    /**
     * @Test sort.
     */
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        BubbleSort sor = new BubbleSort();
        int[] array = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
        int[] rezultTest = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        int[] result = sor.sort(array);
        assertThat(result, is(rezultTest));
    }
}