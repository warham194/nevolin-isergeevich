package ru.ilya.chess.exceptions;

/**
 * Created by Lenovo2 on 17.01.2018.
 */
public class ImpossibleMoveException extends RuntimeException {

    public ImpossibleMoveException() {
        super();
    }

    public ImpossibleMoveException(String message) {
        super(message);
    }
}
