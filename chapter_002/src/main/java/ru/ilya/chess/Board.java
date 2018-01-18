package ru.ilya.chess;

/**
 * Created by Lenovo2 on 17.01.2018.
 */
import ru.ilya.chess.exceptions.FigureNotFoundException;
import ru.ilya.chess.exceptions.ImpossibleMoveException;
import ru.ilya.chess.exceptions.OccupiedWayException;


    public class Board {

        Figure[][] figures = new Figure[8][8];


        boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {
            boolean result = true;
            if (this.figures[source.getX()][source.getY()] == null) {
                result = false;
                throw new FigureNotFoundException();
            }

            Figure figure = this.figures[source.getX()][source.getY()];

            Cell[] Hod = figure.way(source, dest);

            try {
                Hod = figure.way(source, dest);
            } catch (OccupiedWayException o) {
                System.out.println("The way is occupied");
            } catch (ImpossibleMoveException i) {
                System.out.println("The move is impossible");
            }

            for (Cell cell : Hod) {
                if (cell == null) {
                    figure.copy(dest);
                    break;
                }
            }



            return result;
        }

    }