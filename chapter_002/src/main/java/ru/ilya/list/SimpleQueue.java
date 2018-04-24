package ru.ilya.list;

/**
 * Created by Lenovo2 on 24.04.2018.
 */
public class SimpleQueue<T> extends LinkedSimple<T> {

    public T poll() {
        T result = null;
        if (first != null) {
            Node tmp = first;
            first = tmp.right;
            tmp.left = null;
            size--;
            result = (T) tmp.value;
        }
        return result;
    }


    public void push(T value) {
        add(value);
    }
}
