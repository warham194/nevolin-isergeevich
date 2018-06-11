package ru.ilya.tree;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 14.05.2018.
 */
public class TreeTest {
    private Tree<Integer> tree;
    @Before
    public void setUp() {
        tree = new Tree<>(1);
    }
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }


    @Test
    public void whenAddMoreTwoChildToParentThanTreeBecomeNotBinary() {
        Tree<Integer> tree = new Tree<>(1);
        assertThat(tree.isBinary(), is(true));
        tree.add(1, 2);
        assertThat(tree.isBinary(), is(true));
        tree.add(1, 3);
        assertThat(tree.isBinary(), is(false));
        tree.add(1, 4);
        assertThat(tree.isBinary(), is(false));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenHasMoreElementsThanIteratorReturnTrue() {
        tree.add(1, 2);
        tree.add(2, 3);
        tree.add(3, 4);
        Iterator<Integer> it = tree.iterator();
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


}
