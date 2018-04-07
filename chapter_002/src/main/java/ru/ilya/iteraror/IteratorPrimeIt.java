package ru.ilya.iteraror;

import java.util.NoSuchElementException;
import java.util.Iterator;

import static java.lang.StrictMath.sqrt;

/**
 * Created by Lenovo2 on 06.04.2018.
 */
public class IteratorPrimeIt implements Iterator<Integer> {

    private final int[] value;
    private int index = 0;

    public IteratorPrimeIt(int[] array) {
        this.value = array;
    }


    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int a = index; a < value.length; a++) {
            if (prime(value[a])) {
                index = a;
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        return this.value[this.index++];
    }
    /**
     *  Является ли число простым.
     * @param a число для проверки.
     * @return true, если число простое.
     */
    private boolean prime(int a) {
        boolean result = true;
        if (a <= 1) {
            result = false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                result = false;
            }
        }
        return result;
    }
}
