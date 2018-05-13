package ru.ilya.map;

import ru.ilya.list.LinkedSimple;
import ru.ilya.set.LinkedSimpleSet;
import ru.ilya.set.SimpleSet;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 12.05.2018.
 */
public class SimpleHashMap<K, V> implements Iterable<K> {
    private Entry<K, V>[] table;
    private int size;
    private int countItem = 0;
    private static final int DEF_SIZE = 32;

    public SimpleHashMap(int size) {
        this.table = new Entry[(DEF_SIZE > size) ? DEF_SIZE : size];
    }

    public boolean insert(K key, V value) {
        boolean result = false;
        int hash = hash(key.hashCode());
        int i = indexFor(hash, table.length);
        if (table[i] == null) {
            table[i] = new Entry<>(key, value);
            result = true;
            countItem++;
        }
        return result;
    }

    public int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int indexFor(int h, int length) {
        return h & (length-1);
    }






    private class Entry<K, V> {
        private K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
