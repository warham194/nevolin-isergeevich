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
    private Cell[] array = new Cell[8];

    @Override
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException {
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();
        int waypoints = 0;
        Cell[] Hod = new Cell[8];


        if (Math.abs(x1 - x2) != Math.abs(y1 - y2) || (x2 >= 8 || y2 >= 8) || (x2 < 0 || y2 < 0)) {
            throw new ImpossibleMoveException();
        } else {
            if ( x1 < x2 && y1 > y2 ) {
                for (int x = x1 + 1, y = y1 - 1, count = waypoints; x == x2; x++, y--, count++) {
                    Hod[count] = new Cell(x, y);
                }
            } else if ( x1 < x2 && y1 < y2 ) {
                for (int x = x1 + 1, y = y1 + 1, count = waypoints; x <= x2; x++, y++, count++) {
                    Hod[count] = new Cell(x, y);
                }
            } else if ( x1 > x2 && y1 < y2 ) {
                for (int x = x1 - 1, y = y1 + 1, count = waypoints; x == x2; x--, y++, count++) {
                    Hod[count] = new Cell(x, y);
                }
            } else if ( x1 > x2 && y1 > y2 ) {
                for (int x = x1 - 1, y = y1 - 1, count = waypoints; x <= x2; x--, y--, count++) {
                    Hod[count] = new Cell(x, y);
                }
            }
        }


        return Hod;
    }

    @Override
    public Figure copy(Cell dest) {
        return new Bishop(dest);
    }
}
