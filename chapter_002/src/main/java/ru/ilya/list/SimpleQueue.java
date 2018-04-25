package ru.ilya.list;

/**
 * Created by Lenovo2 on 24.04.2018.
 */
public class SimpleQueue<T> extends LinkedSimple<T> {

    public T poll() {
        return removeFirst();
    }


    public void push(T value) {
        add(value);
    }
}
