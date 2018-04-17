package ru.ilya.list;


import org.junit.Test;
import org.junit.Before;


import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by Lenovo2 on 17.04.2018.
 */
public class ArraySimpleTest {
    private ArraySimple arrayList;
    private Iterator iterator;
    private String obj1;
    private String obj2;
    private String obj3;

    @Before
    public void setUp() {
        arrayList = new ArraySimple();
        obj1 = "example1";
        obj2 = "example2";
        obj3 = "example3";
        arrayList.add(obj1);
        arrayList.add(obj2);
        arrayList.add(obj3);
        iterator = arrayList.iterator();
    }

    @Test
    public void whenAddObjectsThenGetThisObjects() {
        assertThat(arrayList.get(0), is(obj1));
        assertThat(arrayList.get(1), is(obj2));
        assertThat(arrayList.get(2), is(obj3));
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
}