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
            int[] array1 = {1, 5, 4, 2};
            int[] array2 = {12, 848 , 7 , 8 ,5 };
            int[] rezultTest = {1, 2, 4, 5, 5, 7, 8, 12, 848};
            int[] result = prov.insertSort(array1, array2);
            assertThat(result, is(rezultTest));
        }
    }


