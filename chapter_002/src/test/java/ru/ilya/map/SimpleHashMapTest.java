package ru.ilya.map;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 12.05.2018.
 */

public class SimpleHashMapTest {
    private SimpleHashMap map;

    @Before
    @Test
    public void setUp() {
        map = new SimpleHashMap(1);
        assertThat(map.insert(1, "User1"), is(true));
        assertThat(map.insert(2, "User2"), is(true));
        assertThat(map.insert(3, "User3"), is(true));
        assertThat(map.insert(4, "User4"), is(true));
        assertThat(map.insert(5, "User5"), is(true));
        System.out.println(map);

    }
/*
    @Test
    public void whenInsertThenReturnTrue() {
        assertThat(map.get(1), is("User1"));
        assertThat(map.get(2), is("User2"));
        assertThat(map.get(3), is("User3"));
        assertThat(map.get(4), is("User4"));
        assertThat(map.get(5), is("User5"));
    }
*/
}