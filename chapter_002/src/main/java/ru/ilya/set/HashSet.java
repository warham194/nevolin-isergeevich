package ru.ilya.set;

import ru.ilya.list.ArraySimple;

import java.util.Objects;

/**
 * Created by Lenovo2 on 05.05.2018.
 */
public class HashSet<E> {
    private SimpleSet<E>[] table;
    //размер таблицы
    private int size;

    public HashSet(int size) {
        this.table = new SimpleSet[size];
        this.size = size;
    }

    public boolean remove(E e) {
        boolean result = false;
        if (e != null && this.contains(e)) {
            int indexE = hash(e);
            SimpleSet<E> temp = table[indexE];
            table[indexE] = new SimpleSet<>();
            for (E e1 : temp) {
                if (!Objects.equals(e, e1)) {
                    table[indexE].add(e1);
                }
            }
            result = true;
        }
        return result;
    }
    public boolean add(E e) {
        boolean result = e != null && !this.contains(e);
        if (result) {
            int indexE = hash(e);
            if (table[indexE] == null) {
                table[indexE] = new SimpleSet<>();
            }
            table[indexE].add(e);
        }

        return result;
    }

    public boolean contains(E e) {
        boolean result = false;
        if (e != null && table[hash(e)] != null) {
            for (E e1 : table[hash(e)]) {
                if (Objects.equals(e, e1)) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    private int hash(E e) {
        int h = e.hashCode();
        h ^= (h >>> 20) ^ (h >>> 12);
        h = h ^ (h >>> 7) ^ (h >>> 4);
        return h & (table.length - 1);
    }




}
