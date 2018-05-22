package ru.ilya.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lenovo2 on 18.05.2018.
 */
public class BinarySearchTreeTest {

    @Test
    public void whenAddElementThenContains() {
        BinarySearchTree<String> test = new BinarySearchTree<>("Test1");
        assertThat(test.add("test1"), is(true));
        assertThat(test.contains("test1"), is(true));
        assertThat(test.contains("Test1"), is(true));
        assertThat(test.contains("test2"), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenCallNextInIteratorObjThanItReturnsNextElementIfHasNext() {
        BinarySearchTree<Integer> test = new BinarySearchTree<>(10);
        test.add(1);
        test.add(166);
        test.add(23);
        test.add(45);
        Iterator<Integer> it = test.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(10));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(166));
        assertThat(it.next(), is(23));
        assertThat(it.next(), is(45));
        it.next();
    }
}