package ru.job4j.loop;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void FactoriallTest() {
        Factorial factor = new Factorial();
        int res = factor.calc(5);
        assertThat(res, is(120));
    }
}