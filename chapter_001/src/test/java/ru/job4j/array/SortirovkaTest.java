package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lenovo2 on 22.10.2017.
 */
public class SortirovkaTest {

        @Test
        public void whenSortArrayWithTenElementsThenSortedArray() {

            Sortirovka prov = new Sortirovka();
            int[] array1 = {1, 4, 5, 848};
            int[] array2 = {5, 7, 8, 12, 900};
            int[] rezultTest = {1, 4, 5, 5, 7, 8, 12, 848, 900};
            int[] result = prov.insertSort(array1, array2);
            assertThat(result, is(rezultTest));
        }
    }


