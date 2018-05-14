package ru.ilya.map;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 12.05.2018.
 */

public class SimpleHashMapTest {
    private SimpleHashMap<Integer, String> map;
    @Before
    public void setUp() {
        map = new SimpleHashMap<>(32);
    }


    @Test
    public void whenInsertTheElementThenMapContainsIt() {
        assertThat(map.getcountItem(), is(0));
        assertTrue(map.insert(1, "value 1"));
        assertThat(map.getcountItem(), is(1));
        assertThat(map.get(1), is("value 1"));
        assertTrue(map.get(2) == null);
    }

    /**
     * Test deleting.
     */
    @Test
    public void whenDeleteTheElementThenMapWillNotContainIt() {
        assertTrue(map.insert(1, "value 1"));
        assertTrue(map.insert(2, "value 2"));
        assertTrue(map.delete(1));
        assertThat(map.get(2), is("value 2"));
        assertTrue(map.get(1) == null);
    }

    /**
     * Test map extending.
     */
    @Test
    public void whenMapGrowsThenLengthShouldIncrease() {
        for (int i = 0; i < 41; i++) {
            map.insert(i, String.format("value %d", i));
        }
        assertTrue(map.getcountItem() == 41);
        assertThat(map.getCapacity(), is(64));
        assertThat(map.get(40), is("value 40"));
    }

    /**
     * Test iterator.
     */
    @Test(expected = NoSuchElementException.class)
    public void whenCallNextOnIteratorThenShouldBeReturnedParticularResultIfHasNext() {
        Iterator<Integer> it = map.iterator();
        for (int i = 0; i < 6; i++) {
            map.insert(i, String.format("value %d", i));
        }
        assertThat(it.next(), is(0));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        it.next();
    }

}