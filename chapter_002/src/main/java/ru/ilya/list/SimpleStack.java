package ru.ilya.list;

import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 24.04.2018.
 */
public class SimpleStack<T> extends LinkedSimple<T> {


    public T poll() {
        T result = null;
        if (second != null) {
            LinkedSimple.Node tmp = second;
            second = tmp.left;
            tmp.right = null;
            size--;
            result = (T) tmp.value;
        }
        return result;
    }


    public void push(T value) {
        add(value);
    }
}
