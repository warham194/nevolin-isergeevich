package ru.ilya.chess;

/**
 * Created by Lenovo2 on 17.01.2018.
 */
 import ru.ilya.chess.exceptions.*;

public abstract class Figure  { //вопрос
    Cell position;
    public Figure(Cell position) {
        this.position = position;
    }
    public abstract Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException;
    public abstract Figure copy(Cell dest);

}
