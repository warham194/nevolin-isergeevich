package ru.ilya.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 20.04.2018.
 */
public class LinkedSimple<E> implements Iterable<E> {

    private Node<E> first;
    private Node<E> second;
    private int size = 0;
    private int counter = 0;


    public void add(E object) {
        Node node = new Node(object, null, null);
        if (isEmpty()) {
            first = node;
            second = node;
        } else {
            node.left = second;
            second.right = node;
            second = node;
        }
        counter++;
        size++;
    }

    public E get(int index) {
        E result = null;
        if (index >= 0 && index < size) {
            Node node = first;
            for (int i = 0; i < size; i++) {
                if (index == i) {
                    result = (E) node.value;
                    break;
                } else {
                    node = node.right;
                }
            }
        }
        return result;
    }


    public boolean isEmpty() {
        return size == 0;
    }
    public int lenght() {
        return size;
    }

    public E removeFirst() {
        E result = null;
        if (first != null) {
            Node tmp = first;
            first = tmp.right;
            tmp.left = null;
            size--;
            result = (E) tmp.value;
        }
        return result;
    }

    public E removeLast() {
        E result = null;
        if (second != null) {
            LinkedSimple.Node tmp = second;
            second = tmp.left;
            tmp.right = null;
            size--;
            result = (E) tmp.value;
        }
        return result;
    }


    private class Node<E> {
        private E value;
        private Node<E> right;
        private Node<E> left;

        /**
         * Конструктор
         * @param value
         * @param right
         * @param left
         */
        public Node(E value, Node left, Node right) {
            this.value = value;
            this.right = right;
            this.left = left;
        }
    }





    @Override
    public Iterator<E> iterator() {

            Node nod = first;
            int expectedModCount = counter;

            return new Iterator<E>() {
                private Node node = nod;

                @Override
                public boolean hasNext() throws ConcurrentModificationException {
                    if (expectedModCount != counter) {
                        throw new ConcurrentModificationException();
                    }
                    return node != null;
                }

                @Override
                public E next() throws NoSuchElementException {
                    if (!this.hasNext()) {
                        throw new NoSuchElementException();
                    }

                    E result = (E) node.value;
                    node = node.right;
                    return result;
                }
            };

    }
}
