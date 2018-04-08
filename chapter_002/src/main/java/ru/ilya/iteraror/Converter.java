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
                if (this.iter.hasNext()) {
                    result = true;
                } else {
                    while (this.main.hasNext()) {
                        this.iter = this.main.next();
                        if (this.iter.hasNext()) {
                            result = true;
                            break;
                        }
                    }
                }
                return result;
            }

            @Override
            public Integer next() {
                int temp = 0;
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (this.main.hasNext()) {
                    temp = this.iter.next();
                } else if (iter == null || !this.iter.hasNext()){
                    this.iter = this.main.next();
                    temp = iter.next();
                }
                return temp;
            }
        };
    }
}
