package ru.ilya.tree;

import org.junit.Test;

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
}