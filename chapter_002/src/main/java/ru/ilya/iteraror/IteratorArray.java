package ru.ilya.iteraror;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 18.03.2018.
 */
public class IteratorArray implements Iterator {

    private final int[][] value;
    private int index1 = 0;
    private int index2 = 0;

    public IteratorArray(int[][] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return value.length > index1 && value[index1].length > index2; //
    }

    @Override
    public Object next() {
        if (Arrays.equals(value, new int[][]{})) {
            throw new NoSuchElementException();
        }
        int result = value[index1][index2];
        if (index2 == value[index1].length - 1) {
            index2 = 0;
            index1++;
        } else {
            index2++;
        }
        return result;
    }
}
