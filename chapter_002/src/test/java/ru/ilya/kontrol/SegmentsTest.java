package ru.ilya.kontrol;

import static org.junit.Assert.*;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * Created by Lenovo2 on 10.06.2018.
 */
public class SegmentsTest {
    Segments test = new Segments();
    @Test
    public void test() {
        Point a = new Point(0);
        Point b = new Point(5);
        Point c = new Point(6);
        Point d = new Point(9);
        assertThat(test.intersectionCheck(a, b, c, d), is(false));
        Point c1 = new Point(4);
        Point d1 = new Point(9);
        assertThat(test.intersectionCheck(a, b, c1, d1), is(true));
        Point a1 = new Point(10);
        Point b1 = new Point(15);
        assertThat(test.intersectionCheck(a1, b1, c, d), is(false));
        Point a2 = new Point(0);
        Point b2 = new Point(5);
        Point c2 = new Point(1);
        Point d2 = new Point(4);
        assertThat(test.intersectionCheck(a2, b2, c2, d2), is(true));
        Point a3 = new Point(0);
        Point b3 = new Point(5);
        Point c3 = new Point(-5);
        Point d3 = new Point(-1);
        assertThat(test.intersectionCheck(a3, b3, c3, d3), is(false));
    }

}