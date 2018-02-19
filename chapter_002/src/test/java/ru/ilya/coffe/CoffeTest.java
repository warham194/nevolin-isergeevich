package ru.ilya.coffe;

/**
 * Created by Lenovo2 on 21.01.2018.
 */

import org.junit.Test;
import ru.ilya.coffe.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeTest {
    @Test
    public void cofeTest() {
        Cof coffe = new Cof();
        int value = 50;
        int price = 35;
        List<Integer> a = new ArrayList<Integer>();
        a = coffe.changes(value, price);
        List<Integer> b = new ArrayList<Integer>();
         b.add(10);
        b.add(5);
        assertThat(a, is(b));
    }
}
