package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с чётным числом элементов, например {2, 6, 1, 4}.
        Turn turn = new Turn();
        int[] array = {2, 6, 1, 4};
        int[] rezultTest = {4, 1, 6, 2};
        int[] result = turn.back(array);
        assertThat(result, is(rezultTest));
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.
        Turn turn = new Turn();
        int[] array = {1, 2, 3, 4, 5};
        int[] rezultTest = {5, 4, 3, 2,1};
        int[] result = turn.back(array);
        assertThat(result, is(rezultTest));
    }
}