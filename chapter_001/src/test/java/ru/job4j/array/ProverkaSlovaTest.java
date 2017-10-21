package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lenovo2 on 21.10.2017.
 */
public class ProverkaSlovaTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        //напишите здесь тест, проверяющий сортировку массива из 10 элементов методом пузырька, например {1, 5, 4, 2, 3, 1, 7, 8, 0, 5}.
        ProverkaSlova prov = new ProverkaSlova();
        prov.contains("Привет", "иве");
        assertThat(prov, is(true));
    }
}
