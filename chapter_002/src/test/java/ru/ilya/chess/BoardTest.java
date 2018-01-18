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





























/*
    @Test
    public void whenMoveFigureWithValidPositiveUpWayThenMove() throws ImpossibleMoveException{
        Board board = new Board();
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(6, 1);
        board.setCurrentFigure(new Bishop(source));
        try {
            board.move(source, dest);
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void whenMoveFigureWithValidPositiveDownWayThenMove() throws ImpossibleMoveException{
        Board board = new Board();
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(6, 7);
        board.setCurrentFigure(new Bishop(source));
        try {
            board.move(source, dest);
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void whenMoveFigureWithValidNegativeUpWayThenMove() throws ImpossibleMoveException{
        Board board = new Board();
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(0, 1);
        board.setCurrentFigure(new Bishop(source));
        try {
            board.move(source, dest);
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void whenMoveFigureWithValidNegativeDownWayThenMove() throws ImpossibleMoveException{
        Board board = new Board();
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(0, 7);
        board.setCurrentFigure(new Bishop(source));
        try {
            board.move(source, dest);
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void whenMoveFigureWithInvalidWayThenGetException() throws ImpossibleMoveException{
        Board board = new Board();
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(10, 10);
        board.setCurrentFigure(new Bishop(source));
        try {
            board.move(source, dest);
        } catch (ImpossibleMoveException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }

    @Test
    public void whenMoveFigureWithValidOccupiedWayThenMove() throws OccupiedWayException{
        Board board = new Board();
        Cell source = new Cell(3, 4);
        Cell dest = new Cell(6, 7);
        Cell occupiedSource = new Cell(6, 5);
        Cell occupiedDest = new Cell(5, 6);
        board.setCurrentFigure(new Bishop(occupiedSource));
        board.move(occupiedSource, occupiedDest);
        board.setCurrentFigure(new Bishop(source));
        try {
            board.move(source, dest);
        } catch (OccupiedWayException ex) {
            Assert.assertNotEquals("", ex.getMessage());
        }
    }*/
}
