package ru.ilya.list;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import ru.ilya.list.LinkedSimple;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by Lenovo2 on 20.04.2018.
 */
public class LinkedSimpleTest {

    private LinkedSimple linkedList;
    private Iterator iterator;
    private String obj1;
    private String obj2;
    private String obj3;

    @Before
    public void setUp() {
        linkedList = new LinkedSimple();
        obj1 = "example1";
        obj2 = "example2";
        obj3 = "example3";
        linkedList.add(obj1);
        linkedList.add(obj2);
        linkedList.add(obj3);
        iterator = linkedList.iterator();
    }

    @Test
    public void whenGetObjects() {
        assertThat(linkedList.get(0), is(obj1));
        assertThat(linkedList.get(1), is(obj2));
        assertThat(linkedList.get(2), is(obj3));
    }
    @Test(expected = NoSuchElementException.class)
    public void whenIteratorHasNextAndNext() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(obj1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(obj2));
        assertThat(iterator.next(), is(obj3));
        assertThat(iterator.hasNext(), is(false));
        iterator.next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenIteratorNextThenCME() {
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(obj1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next(), is(obj2));
        linkedList.add("mod");
        iterator.hasNext();
    }

}