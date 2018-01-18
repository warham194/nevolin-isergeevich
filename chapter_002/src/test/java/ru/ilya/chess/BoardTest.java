package ru.ilya.chess;

/**
 * Created by Lenovo2 on 17.01.2018.
 */

import org.junit.Test;
import ru.ilya.chess.exceptions.*;
import ru.ilya.chess.figures.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BoardTest {

    @Test
    public void whenMoveUnexistFigureThenGetException() throws FigureNotFoundException {
        Board board = new Board(); // создаем объект типа Board
        Cell source = new Cell(0, 0);
        Cell dest = new Cell(7, 7);
        Figure bishop = new Bishop(source);
        boolean two = board.move(source, dest);
        boolean one = true;
        assertThat(true, is(two));

    }

}
