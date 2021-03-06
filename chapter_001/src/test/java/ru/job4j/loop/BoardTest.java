package ru.job4j.loop;

import org.junit.Test;

import static java.lang.System.lineSeparator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Ilya
 * @version 1
 * @since 0.1
 */
public class BoardTest {
    /**
     * @Test format.
     */
    @Test
    public void whenPaintingBoardThreeWidthAndThreeHeightThenResultIsThreeRowAndThreeColBoard() {
        Board board = new Board();
        String result = board.paint(3, 3);
        String separator = System.lineSeparator();
        String expected = String.format("x x%s x %sx x%s", separator, separator, separator);
        assertThat(result, is(expected));
    }

    /**
     * Тест метода Board.paint().
     * Проверятся рисование шахматной доски размером 5х4.
     */
    @Test
    public void whenPaintingBoardFiveWidthAndFourHeightThenResultIsFourRowAndFiveColBoard() {
        Board board = new Board();
        String result = board.paint(5, 4);
        String separator = System.lineSeparator();
        String expected = String.format("x x x%s x x %sx x x%s x x %s", separator, separator, separator, separator);
        assertThat(result, is(expected));
    }
}