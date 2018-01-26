package ru.ilya.chess.figures;

import ru.ilya.chess.Cell;
import ru.ilya.chess.Figure;
import ru.ilya.chess.exceptions.ImpossibleMoveException;

/**
 * Created by Lenovo2 on 17.01.2018.
 */
public class Bishop extends Figure {


    public Bishop(Cell position) { //вопрос
        super(position);
    }

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();

        if (Math.abs(x1 - x2) != Math.abs(y1 - y2) || (x2 >= 8 || y2 >= 8) || (x2 < 0 || y2 < 0)) {
            throw new ImpossibleMoveException();
        } else {
            int moveLength = Math.abs(x1 - x2);
            Cell[] waypoints = new Cell[moveLength];
            int horizontal = Integer.compare(x2, x1);
            int vertical = Integer.compare(y2, y1);
            for (int index = 0; index != moveLength; index++) {
                x1 += horizontal;
                y1 += vertical;
                waypoints[index] = new Cell(x1, y1);
            }
            return waypoints;
        }
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
