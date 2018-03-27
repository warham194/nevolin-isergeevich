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
        /*
        if (Arrays.equals(value, new int[]{})) {   проверка должна быть в методе next() или hasNext()?
            throw new NoSuchElementException();
        }
         */
        if (index < value.length - 1) {
            for (int a = index; a < value.length; a++) {
                if (value[a] % 2 == 0) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        int result = 0;
        for (int i = index; i < value.length; i++) {
            if (value[i] % 2 == 0 ) {
                result = value[i];
                index++;
                break;
            }
            if (hasNext() == false) {
                throw new NoSuchElementException();
            }
            index++;
        }
        return result;
    }
}
