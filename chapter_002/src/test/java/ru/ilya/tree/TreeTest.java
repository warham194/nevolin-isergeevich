package ru.ilya.tree;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 14.05.2018.
 */
public class TreeTest {
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


}
