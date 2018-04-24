package ru.ilya.list;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;


import java.util.EmptyStackException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Lenovo2 on 24.04.2018.
 */
public class SimpleStackTest {
    private SimpleStack<String> testedStack;
    private String first = String.valueOf("first");
    private String second = String.valueOf("second");
    private String third = String.valueOf("third");

    /**
     * Set up before tests.
     */
    @Before
    public void setUp() {
        testedStack = new SimpleStack<String>();
        testedStack.push(first);
        testedStack.push(second);
        testedStack.push(third);
    }

    /**
     * Test pop method's.
     */
    @Test
    public void whenPopThenReturnedAndRemovedLast() {
        assertThat(testedStack.poll(), is(third));
        assertThat(testedStack.poll(), is(second));
        assertThat(testedStack.poll(), is(first));
    }
}