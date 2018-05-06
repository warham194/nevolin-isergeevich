package ru.ilya.set;

import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 06.05.2018.
 */
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
public class HashSetTest {

    private HashSet<String> set;
    private String st1 = "string1";
    private String st2 = "string2";
    private String st3 = "string3";
    private String st4 = "string4";
    private String st5 = "string5";

    @Before
    public void setUp() {
        set = new HashSet<String>(1);
        assertThat(set.add(st1), is(true));
        assertThat(set.add(st2), is(true));
        assertThat(set.add(st3), is(true));
        assertThat(set.add(st4), is(true));
        assertThat(set.add(st5), is(true));
    }

    @Test
    public void whenContainsReturnTrueAndFalse() {
        assertThat(set.contains(st1), is(true));
        assertThat(set.contains(st2), is(true));
        assertThat(set.contains(st3), is(true));
        assertThat(set.contains(st4), is(true));
        assertThat(set.contains(st5), is(true));
        assertThat(set.contains("false"), is(false));
    }

    @Test
    public void whenAddDuplicateThenReturnFalse() {
        assertThat(set.add(st1), is(false));
        assertThat(set.add(st2), is(false));
        assertThat(set.add(st3), is(false));
        assertThat(set.add(st4), is(false));
        assertThat(set.add(st5), is(false));
        assertThat(set.add(null), is(false));
    }

    @Test
    public void whenRemoveStringsThenNotContains() {
        assertThat(set.remove("false"), is(false));
        assertThat(set.remove(st1), is(true));
        assertThat(set.remove(st2), is(true));
        assertThat(set.remove(st3), is(true));
        assertThat(set.remove(st4), is(true));
        assertThat(set.remove(st5), is(true));
        assertThat(set.contains(st1), is(false));
        assertThat(set.contains(st2), is(false));
        assertThat(set.contains(st3), is(false));
        assertThat(set.contains(st4), is(false));
        assertThat(set.contains(st5), is(false));
    }

    @Test
    public void whenResize() {
        assertThat(set.add("string6"), is(true));
        assertThat(set.add("string7"), is(true));
        assertThat(set.add("string9"), is(true));
        assertThat(set.add("string10"), is(true));
        assertThat(set.add("string11"), is(true));
        assertThat(set.add("string12"), is(true));
        assertThat(set.add("string13"), is(true));
        assertThat(set.add("string14"), is(true));
        assertThat(set.add("string15"), is(true));
        assertThat(set.add("string16"), is(true));
        assertThat(set.add("string17"), is(true));
        assertThat(set.contains(st1), is(true));
        assertThat(set.contains(st2), is(true));
        assertThat(set.contains(st3), is(true));
        assertThat(set.contains(st4), is(true));
        assertThat(set.contains(st5), is(true));
        assertThat(set.contains("string6"), is(true));
        assertThat(set.contains("string7"), is(true));
        assertThat(set.contains("string9"), is(true));
        assertThat(set.contains("string10"), is(true));
        assertThat(set.contains("string11"), is(true));
        assertThat(set.contains("string12"), is(true));
        assertThat(set.contains("string13"), is(true));
        assertThat(set.contains("string14"), is(true));
        assertThat(set.contains("string15"), is(true));
        assertThat(set.contains("string16"), is(true));
        assertThat(set.contains("string17"), is(true));
    }
}