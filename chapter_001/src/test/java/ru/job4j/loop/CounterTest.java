package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CounterTest {
    @Test
    public void SummaChetn() {
        Counter counter = new Counter();
        int res = counter.add(0, 10);
        assertThat(res, is(30));
    }
}

