package ru.ilya.kontrol;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 27.05.2018.
 */
public class SimileTest {
    Simile c = new Simile();
    @Test
    public void test() {
        assertThat(c.comWords("Ilya", "Ilya"), is(true));
        assertThat(c.comWords("Ilya", "Il"), is(false));
        assertThat(c.comWords("Ilya", "IlleJ"), is(false));
        assertThat(c.comWords("assaasa", "asddadAssa"), is(false));
        assertThat(c.comWords("Ilya12", "2Ilya1"), is(true));
    }

}