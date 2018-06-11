package ru.ilya.kontrol;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 31.05.2018.
 */
public class IssuerTest {

    @Test
    public void whenAddTwoBidsToStockAndDelete() {
        Glass glass = new Glass();
        Application gazpromFirst = new Application("gazprom", Type.ADD, Action.BUY, 15, 20);
        Application deleteGazprom1 = new Application("gazprom", Type.ADD, Action.BUY, 15, 20);
        Application deleteGazprom2 = new Application("gazprom", Type.ADD, Action.BUY, 7, 20);
        Application deleteGazprom3 = new Application("gazprom", Type.ADD, Action.BUY, 333, 20);
        Application lukoil = new Application("lukoil", Type.ADD, Action.BUY, 25, 15);
        glass.addOrder(gazpromFirst);
        glass.addOrder(lukoil);
        glass.addOrder(deleteGazprom1);
        glass.addOrder(deleteGazprom2);
        glass.addOrder(deleteGazprom3);


    }

}