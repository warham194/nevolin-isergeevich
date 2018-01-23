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
public class FactorialTest {
    /**
     * @Test calc.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial factor = new Factorial();
        int res = factor.calc(5);
        assertThat(res, is(120));
    }
}