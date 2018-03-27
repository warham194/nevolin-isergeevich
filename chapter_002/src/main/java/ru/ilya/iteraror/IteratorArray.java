package ru.ilya.iteraror;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 18.03.2018.
 */
public class IteratorArray implements Iterator {

    private final int[][] value;
    private int indexOne = 0;
    private int indexTwo = 0;

    public IteratorArray(int[][] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return value.length > indexOne && value[indexOne].length > indexTwo; //
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int result = value[indexOne][indexTwo];
        if (indexTwo == value[indexOne].length - 1) {
            indexTwo = 0;
            indexOne++;
        } else {
            indexTwo++;
        }
        return result;
    }
}
