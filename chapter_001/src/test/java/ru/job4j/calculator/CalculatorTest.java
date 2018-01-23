package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Test.
 * @author Ilya
 * @version 1
 * @since 0.1
 */
public class CalculatorTest {
    /**
     * @Test add.
     */
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    /**
     * @Test sub.
     */
	 public void whenTwoSubOneThenOne() {
        Calculator calc = new Calculator();
        calc.sub(2D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    /**
     * @Test mul.
     */
	 public void whenThreeMulTwoThenSex() {
        Calculator calc = new Calculator();
        calc.mul(3D, 2D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }
    /**
     * @Test div.
     */
	 public void whenFourDivTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}