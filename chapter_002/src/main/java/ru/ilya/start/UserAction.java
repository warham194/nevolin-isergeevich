package ru.ilya.start;

/**
 * Created by Lenovo2 on 03.12.2017.
 */
import ru.ilya.models.*;

public interface UserAction {
    int key();
    void execute(Input input, Tracker tracker);
    String info();
}
