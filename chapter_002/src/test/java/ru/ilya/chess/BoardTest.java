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
        assertThat(two, is(new Cell[]{new Cell(1,1),new Cell(2,2)}));

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
    public void whenMoveFigureWithValidPositiveUpWayThenMove() throws ImpossibleMoveException{
        Board board = new Board();
        Cell source = new Cell(0, 0);
        Cell dest = new Cell(2, 3);
        Figure bishop = new Bishop(source);
        try {
            board.placeFigures(0,0,bishop);
            Cell[] Hod = bishop.way(source, dest);
            board.move(source, dest);
            Assert.fail("ImpossibleMoveException expected");
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }
    @Test
    public void whenMoveBishopWithValidOccupiedWayThenGetException() throws OccupiedWayException {
        Board board = new Board();
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(6, 7);
        Cell occupiedSource = new Cell(6, 5);
        Cell occupiedDest = new Cell(5, 6);
        Bishop one = new Bishop(occupiedSource);
        Bishop two = new Bishop(source);
        board.placeFigures(6,5,one);
        board.move(occupiedSource, occupiedDest);
        board.placeFigures(3,4,two);
        try {
            board.move(source, dest);
        } catch (OccupiedWayException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }


    }


