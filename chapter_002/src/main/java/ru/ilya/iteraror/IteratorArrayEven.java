package ru.ilya.iteraror;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 21.03.2018.
 */
public class IteratorArrayEven implements Iterator<Integer> {

    private final int[] value;
    private int index = 0;

    public IteratorArrayEven(int[] value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {

        boolean result = false;
        for (int a = index; a < value.length; a++) {
            if (value[a] % 2 == 0) {
                index = a;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {  //{1, 2, 3, 4, 5, 6, 7}
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }

        return this.value[this.index++];
    }
}
