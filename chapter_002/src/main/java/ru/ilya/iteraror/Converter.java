package ru.ilya.iteraror;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 08.04.2018.
 */
public class Converter {

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Iterator<Integer>> main = it;
            Iterator<Integer> iter = main.next();

            @Override
            public boolean hasNext() {
                boolean result = false;
                if (iter.hasNext()) {
                    result = true;
                } else {
                    while (main.hasNext()) {
                        this.iter = main.next();
                        if (iter.hasNext()) {
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (!iter.hasNext() && main.hasNext()) {
                    iter = main.next();
                }
                return iter.next();
            }
        };
    }
}
