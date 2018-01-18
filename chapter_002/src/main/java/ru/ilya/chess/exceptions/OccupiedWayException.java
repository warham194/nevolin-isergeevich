package ru.ilya.chess.exceptions;

/**
 * Created by Lenovo2 on 17.01.2018.
 */
public class OccupiedWayException extends RuntimeException {

    public OccupiedWayException() {
        super();
    }
    public OccupiedWayException(String message) {
        super(message);
    }
}