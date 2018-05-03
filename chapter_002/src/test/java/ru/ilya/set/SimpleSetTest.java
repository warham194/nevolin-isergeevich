package ru.ilya.set;

import org.junit.Before;
import org.junit.Test;
import ru.ilya.list.ArraySimple;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 03.05.2018.
 */
public class SimpleSetTest {
    private SimpleSet simpleSet;
    private Iterator iterator;
    private String obj1;
    private String obj2;
    private String obj3;

    @Before
    public void setUp() {
        simpleSet = new SimpleSet();
        obj1 = "example1";
        obj2 = "example2";
        obj3 = "example3";
        simpleSet.add(obj1);
        simpleSet.add(obj2);
        simpleSet.add(obj3);
        iterator = simpleSet.iterator();
    }

    @Test
    public void whenAddObjectsThenGetThisObjects() {
        assertThat(simpleSet.get(0), is(obj1));
        assertThat(simpleSet.get(1), is(obj2));
        assertThat(simpleSet.get(2), is(obj3));
    }

    @Test
    public void whenAddDuplicateThenNotAdd() {
        assertThat(simpleSet.get(0), is("example1"));
        assertThat(simpleSet.get(1), is("example2"));
        assertThat(simpleSet.get(2), is("example3"));
        simpleSet.add("example1");
        simpleSet.add("example3");
        assertThat(simpleSet.lenght(), is(3));
    }


}