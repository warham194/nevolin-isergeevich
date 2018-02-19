package ru.ilya.chess;

/**
 * Created by Lenovo2 on 17.01.2018.
 */

import org.junit.Test;
import ru.ilya.chess.exceptions.*;
import ru.ilya.chess.figures.*;
import org.junit.Assert;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
public class BoardTest {
    @Test
    public void whenMove() {
        Cell source = new Cell(0, 0);
        Cell dest = new Cell(2, 2);
        Figure bishop = new Bishop(source);
        Cell[] two = bishop.way(source, dest);
        assertThat(two, is(new Cell[]{new Cell(1, 1), new Cell(2, 2)}));
    }
    @Test
    public void whenMoveUnexistFigureThenGetException() throws FigureNotFoundException {
        Board board = new Board();
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(5, 2);
        try {

            board.move(source, dest);
            Assert.fail("FigureNotFoundExcepion expected");
        } catch (FigureNotFoundException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }
    @Test
    public void whenMoveFigureWithValidPositiveUpWayThenMove() throws ImpossibleMoveException {
        Board board = new Board();
        Cell source = new Cell(0, 0);
        Cell dest = new Cell(2, 3);
        Figure bishop = new Bishop(source);
        try {
            board.placeFigures(0, 0, bishop);
            board.move(source, dest);
            Assert.fail("ImpossibleMoveException expected");
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }
    @Test(expected = OccupiedWayException.class)
    public void whenMoveBishopWithValidOccupiedWayThenGetException() {
        Board board = new Board();
        Cell source = new Cell(1, 1);
        Cell dest = new Cell(3, 3);
        Cell occupiedSource = new Cell(2, 2);
        Cell occupiedDest = new Cell(3, 3);
        Bishop one = new Bishop(occupiedSource);
        Bishop two = new Bishop(source);
        board.placeFigures(2, 2, one);
        board.move(occupiedSource, occupiedDest);
        board.placeFigures(1, 1, two);
        board.move(source, dest);

    }
    }


//@Test(expected = Exception.class)