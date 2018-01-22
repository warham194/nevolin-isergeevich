package ru.ilya.coffe;

/**
 * Created by Lenovo2 on 21.01.2018.
 */

import org.junit.Test;
import ru.ilya.coffe.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CoffeTest {


    @Test
    public void CofTest() {
        Cof coffe = new Cof();
        int value = 50;
        int price = 35;
        int[] a = coffe.changes(value,price);
        int[] b = {10, 5};
        assertThat(a, is(b));



    }
}
