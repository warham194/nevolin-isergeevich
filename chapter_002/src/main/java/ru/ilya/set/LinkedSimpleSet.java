package ru.ilya.set;

import ru.ilya.list.LinkedSimple;

import java.util.Iterator;

/**
 * Created by Lenovo2 on 04.05.2018.
 */
public class LinkedSimpleSet<E> implements Iterable<E> {

    private final LinkedSimple<E> list = new LinkedSimple();

    public void add(E e) {
        if (dooblicate(e)) {
            list.add(e);
        }
    }

    private boolean dooblicate(E e) {
        boolean result = true;
        if (e != null) {
            for (E item : list) {
                if (e.equals(item)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public E get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.lenght();
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
