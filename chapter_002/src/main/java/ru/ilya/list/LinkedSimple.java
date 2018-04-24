package ru.ilya.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Created by Lenovo2 on 20.04.2018.
 */
public class LinkedSimple<E> implements Iterable<E> {

    private Node<E> first = new Node<E>(0, null, null, null);
    private Node<E> second = new Node<E>(0, null, null, null);
    private int size = 0;
    private int counter = 0;

    /**
     * Метод добавления элемента в список.
     * @param element
     */
    public void add(E element) {
        Node node = new Node(size++, element, second, null);
        if (first.next == null) {
            first.next = node;
        } else {
            second.next = node;
        }
        second = node;
        counter++;
    }

    public E get(int index) {

            E result = null;
            Node node = second;
            for (int i = 0; i < this.size; i++) {
                if (index == node.index) {
                    result = (E) node.value;
                } else {
                    node = node.previous;
                }
            }
            return result;
        }


    private class Node<E> {
        private E value;
        public int index;
        private Node previous;
        private Node next;

        /**
         * Конструктор
         * @param index
         * @param value
         * @param next
         * @param previous
         */
        public Node(int index, E value, Node previous, Node next) {
            this.value = value;
            this.next = next;
            this.previous = previous;
            this.index = index;
        }
    }





    @Override
    public Iterator<E> iterator() {

            Node nod = first.next;
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
                    node = node.next;
                    return result;
                }
            };

    }
}
