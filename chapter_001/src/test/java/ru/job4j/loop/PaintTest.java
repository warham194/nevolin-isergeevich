package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Ilya
 * @version 1
 * @since 0.1
 */
public class PaintTest {
    /**
     * @Test format.
     */
    @Test
    public void whenWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ %s^^^", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
    /**
     * @Test format.
     */
    @Test
    public void whenWithHeightThreeThenStringWithThreeRows() {
        //напишите здесь тест, проверяющий формирование пирамиды для высоты 3.
        Paint paint = new Paint();
        String line = System.lineSeparator();
        String result = paint.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^", line, line, line);
        assertThat(result, is(expected));
    }
}