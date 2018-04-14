package ru.ilya.generic;

import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 12.04.2018.
 */
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;

public class SimpleArrayTest {
    private SimpleArray<Integer> simpleArray;

    @Before
    public void setUp() {
        simpleArray = new SimpleArray<Integer>(5);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
    }

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleArray<String> simple = new SimpleArray<String>(4);
        simple.add("test");

        assertThat(simple.get(0), is("test"));
    }

    @Test
    public void whenTypeIntShouldReturnInt() {
        assertThat(this.simpleArray.get(0), is(0));
        assertThat(this.simpleArray.get(2), is(2));
        assertThat(this.simpleArray.get(4), is(4));
    }


    @Test
    public void whenUpdateInt() {
        this.simpleArray.set(3, 10);
        assertThat(this.simpleArray.get(3), is(10));
    }
    @Test(expected = NoSuchElementException.class)
    public void hasNextNextSequentialInvocation() {
        Iterator it = simpleArray.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(0));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
        it.next();
    }

    @Test
    public void whenDeleteIntThenGetOfIndexDeletedNextInt() {
        this.simpleArray.delete(3);
        assertThat(this.simpleArray.get(3), is(4));
    }

}