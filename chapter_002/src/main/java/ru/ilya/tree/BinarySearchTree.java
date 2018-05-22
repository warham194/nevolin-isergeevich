package ru.ilya.tree;

import java.util.*;

/**
 * Created by Lenovo2 on 18.05.2018.
 */
public class BinarySearchTree<E extends Comparable<E>> implements Iterable<E> {

    private BinarySearchTree<E> left;
    private BinarySearchTree<E> right;
    private E value;

    public BinarySearchTree(E value) {
        if (value == null) {
            throw new NoSuchElementException("Ошибка");
        }
        this.value = value;
    }

    public boolean add(E e) {
        boolean result = false;
        if (e != null) {
            BinarySearchTree<E> newTree = findElement(e);
            int compare = newTree.value.compareTo(e);
            if (compare < 0) {
                newTree.right = new BinarySearchTree<>(e);
                result = true;
            } else if (compare > 0) {
                newTree.left = new BinarySearchTree<>(e);
                result = true;
            }
        }
        return result;
    }

    private BinarySearchTree<E> findElement(E e) {
        BinarySearchTree<E> result = this;
        int compare = value.compareTo(e);
        if (compare < 0  && right != null) {
            result = right.findElement(e);
        } else if (compare > 0 && left != null) {
            result = left.findElement(e);
        }
        return result;
    }

    public boolean contains(E e) {
        return findElement(e).value.equals(e);
    }


    public Iterator<E> iterator() {
         class BSTIterator implements Iterator<E> {
             private LinkedList<BinarySearchTree> list = new LinkedList<>();
             private BSTIterator() {
                 list.add(BinarySearchTree.this);
             }

             @Override
             public boolean hasNext() {
                 return !list.isEmpty();
             }

             @Override
             public E next() {
                 if (!hasNext()) {
                     throw new NoSuchElementException();
                 }
                 BinarySearchTree<E> result = list.removeFirst();
                 if (result.left != null) {
                     list.add(result.left);
                 }
                 if (result.right != null) {
                     list.add(result.right);
                 }
                 return result.value;
             }
         }


        return new BSTIterator();
    }
}
