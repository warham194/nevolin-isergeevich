package ru.ilya.set;

import ru.ilya.list.ArraySimple;

import java.util.Iterator;

/**
 * Created by Lenovo2 on 03.05.2018.
 */

public class SimpleSet<E> implements Iterable<E> {

    private final ArraySimple<E> glass = new ArraySimple();
    /**
     * Метод добавления элемента без дубликатов
     * @param e
     */
    public void add(E e) {
        if (dooblicate(e)) {
            glass.add(e);
        }
    }


    public E get(int index) {
        return glass.get(index);
    }
    /**
     * Проверка на дубоикаты
     * @param e
     * @return
     */
    private boolean dooblicate(E e) {
        boolean result = true;
        if (e != null) {
            for (E item : glass) {
                if (e.equals(item)) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public int lenght() {
        return glass.lenght();
    }

    @Override
    public Iterator<E> iterator() {
        return glass.iterator();
    }
}
