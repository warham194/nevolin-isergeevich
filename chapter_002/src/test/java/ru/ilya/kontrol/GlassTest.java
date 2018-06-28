package ru.ilya.kontrol;

import org.junit.Before;
import org.junit.Test;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import static org.junit.Assert.*;

/**
 * Created by Lenovo2 on 01.06.2018.
 */
public class GlassTest {
    private Glass dom;

    @Before
    public void init() {
        this.dom = new Glass();
    }

    @Test
    public void printGlassTest() {
        System.out.println("Покупка  цена  Продажа");
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.BUY, 52, 18));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.SELL, 181, 14));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.BUY, 50, 11));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.SELL, 190, 2));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.BUY, 60, 4));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.SELL, 160, 6));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.BUY, 20, 178));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.SELL, 140, 15)); // колличество акций должно быть равно 10
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.SELL, 89, 2)); // должна исчезнуть
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.BUY, 90, 5));  //  колличество акций должно быть равно 3
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.SELL, 190, 3));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.BUY, 141, 5)); // должна исчезнуть
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.BUY, 34, 2));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.SELL, 158, 13));
        this.dom.orderHandler(new Application("GAZPROM1", Type.ADD, Action.BUY, 141, 5)); // должна исчезнуть
        this.dom.orderHandler(new Application("GAZPROM1", Type.ADD, Action.BUY, 34, 2));
        this.dom.orderHandler(new Application("GAZPROM1", Type.ADD, Action.SELL, 158, 13));
        this.dom.printGlass("GAZPROM");
        System.out.println();
        this.dom.printGlass("GAZPROM1");
    }
}