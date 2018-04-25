package ru.ilya.list;

import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 24.04.2018.
 */
public class SimpleStack<T> extends LinkedSimple<T> {


    public T poll() {
        return  removeLast();
    }


    public void push(T value) {
        add(value);
    }
}
