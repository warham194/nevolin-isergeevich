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
        if (index < value.length - 1) {
            for (int a = index; a < value.length; a++) {
                if (prime(value[a])) {
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
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            if (prime(value[i])) {
                result = value[i];
                index++;
                break;
            }

            index++;
        }
        return result;
    }
    /**
     *  Является ли число простым.
     * @param a число для проверки.
     * @return true, если число простое.
     */
    private boolean prime(int a) {
        boolean result = true;
        double s = sqrt(a);
        if (a < 2) {
            result = false;
        }  else if (a % 2 == 0) {
            result = false;
        } else {
            for (int i = 2; i <= s; i++) {
                if (a % i == 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}
