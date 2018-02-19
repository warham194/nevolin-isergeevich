package ru.ilya.chess;

/**
 * Created by Lenovo2 on 17.01.2018.
 */
import ru.ilya.chess.exceptions.FigureNotFoundException;
import ru.ilya.chess.exceptions.ImpossibleMoveException;
import ru.ilya.chess.exceptions.OccupiedWayException;


    public class Board {
        Figure[][] figures = new Figure[8][8];

        public Figure[][] placeFigures(int i, int j, Figure figure) throws FigureNotFoundException {
            figures[i][j] = figure;
            if (figures [i][j] == figure) {
                System.out.println("");
            } else {
                throw  new FigureNotFoundException();
            }
            return figures;
        }
        boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
            boolean result = true;
            if (this.figures[source.getX()][source.getY()] == null) {
                result = false;
                throw new FigureNotFoundException();
            }
            Figure figure = this.figures[source.getX()][source.getY()];
            Cell[] steps = figure.way(source, dest);
            for (Cell cell : steps) {
                if (this.figures[cell.getX()][cell.getY()] != null) {
                    result = false;
                    throw new OccupiedWayException();
                }
            }
            try {
                figure.way(source, dest);
            } catch (ImpossibleMoveException i) {
                System.out.println("The move is impossible");
            }
            return result;
        }
    }