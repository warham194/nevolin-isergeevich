package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Ilya
 * @version 1
 * @since 0.1
 */
public class CounterTest {
    /**
     * @Test add.
     */
    @Test
    public void addTest() {
        Counter counter = new Counter();
        int res = counter.add(0, 10);
        assertThat(res, is(30));
    }
}

