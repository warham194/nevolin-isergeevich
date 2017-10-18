package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        ArrayDuplicate sor = new ArrayDuplicate();
        String[] strings = {"6","6","7","7","4","8","4","5","6","8", "8", "4", "7","6"};
        String[] rezultTest = {"6", "7","8","4","5"};
        String[] result = sor.remove(strings);
        assertThat(result, is(rezultTest));
    }
}