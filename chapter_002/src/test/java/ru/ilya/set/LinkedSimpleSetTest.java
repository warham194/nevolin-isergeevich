package ru.ilya.set;

import org.junit.Before;
import org.junit.Test;
import ru.ilya.list.LinkedSimple;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 04.05.2018.
 */
public class LinkedSimpleSetTest {
    private LinkedSimpleSet list;
    private Iterator iterator;
    private String obj1;
    private String obj2;
    private String obj3;


    @Before
    public void setUp() {
        list = new LinkedSimpleSet();
        obj1 = "example1";
        obj2 = "example2";
        obj3 = "example3";
        list.add(obj1);
        list.add(obj2);
        list.add(obj3);
        iterator = list.iterator();
    }

    @Test
    public void whenGetObjects() {
        assertThat(list.get(0), is(obj1));
        assertThat(list.get(1), is(obj2));
        assertThat(list.get(2), is(obj3));
        list.add("example1");
        list.add("example3");
        assertThat(list.size(), is(3));
    }

}