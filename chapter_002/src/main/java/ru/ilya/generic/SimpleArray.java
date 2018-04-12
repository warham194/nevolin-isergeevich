package ru.ilya.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 12.04.2018.
 */
public class SimpleArray<T> implements Iterable<T> {

    Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T model) {
        this.objects[index++] = model;
    }

    public void set(int index, T model) {
        this.objects[index] = model;
    }

    public T get(int index) throws ArrayIndexOutOfBoundsException {
        return (T) this.objects[index];
    }

    public void delete(int index) {
        this.objects[index] = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return this.iteratorIndex < index;
            }

            @Override
            public T next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }

                return (T) objects[this.iteratorIndex++];
            }
        };
    }
}
