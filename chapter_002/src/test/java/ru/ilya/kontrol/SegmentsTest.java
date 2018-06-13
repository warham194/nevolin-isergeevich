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
    }

}