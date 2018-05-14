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
        int index = hashIndex(key);
        if (table[index] == null) {
            if (countItem > table.length * 0.7) {
                grow();
            }
            table[index] = new Entry<>(key, value);
            result = true;
            countItem++;
        }
        return result;
    }

    public V get(K key) {
        int index = hashIndex(key);
        return table[index] == null ? null : (V) table[index].value;
    }

    private void insert(Entry<K, V> e) {
        insert(e.key, e.value);
    }


    private void grow() {
        Entry<K, V>[] tab = table;
        table = new Entry[table.length * 2];
        countItem = 0;
        for (Entry<K, V> element : tab) {
            if (element != null) {
                insert(element);
            }
        }
    }

    public boolean delete(K key) {
        boolean result = false;
        int index = hashIndex(key);
        if (table[index] != null) {
            table[index] = null;
            result = true;
            countItem--;
        }
        return result;
    }



    public int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private int hashIndex(K key) {
        return (key == null) ? 0 : key.hashCode() % table.length;
    }

    public int getcountItem() {
        return countItem;
    }

    public int getCapacity() {
        return table.length;
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
        return new Iterator<K>() {
            private int nextIndex = 0, nextCounter = 0;
            @Override
            public boolean hasNext() {
                return nextCounter < countItem;
            }


            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                nextCounter++;
                while (table[nextIndex] == null) {
                    nextIndex++;
                }
                return (K) table[nextIndex++].key;
            }
        };
    }
}
