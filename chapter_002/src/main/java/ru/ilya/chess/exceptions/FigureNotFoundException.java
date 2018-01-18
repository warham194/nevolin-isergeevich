package ru.ilya.chess.exceptions;

/**
 * Created by Lenovo2 on 17.01.2018.
 */
public class FigureNotFoundException extends RuntimeException {

    public FigureNotFoundException() {
        super();
    }

    public FigureNotFoundException(String message) {
        super(message);
    }
}
