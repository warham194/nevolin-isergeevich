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
        this.dom.printGlass("GAZPROM");
    }

    @Test
    public void whenAddTypeOrderThenVolumeIncrease() {
        Application order = new Application("GAZPROM", Type.ADD, Action.BUY, 45, 15);
        this.dom.orderHandler(order);
        assertThat(this.dom.getGlasses().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getBuyList().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getSellList().size(), is(0));
        assertThat(this.dom.getGlasses().get(0).getBook(), is("GAZPROM"));
        Application tmp = this.dom.getGlasses().get(0).getBuyList().iterator().next();
        assertThat(tmp.getVolume(), is(15));
        Application order1 = new Application("GAZPROM", Type.ADD, Action.BUY, 45, 5);
        this.dom.orderHandler(order1);
        assertThat(this.dom.getGlasses().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getBuyList().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getSellList().size(), is(0));
        assertThat(tmp.getVolume(), is(20));
    }

    @Test
    public void whenAddTypeOrderWithOtherPriceThenGlassSize() {
        Application order = new Application("GAZPROM", Type.ADD, Action.BUY, 45, 10);
        this.dom.orderHandler(order);
        Application order1 = new Application("GAZPROM", Type.ADD, Action.BUY, 44, 10);
        this.dom.orderHandler(order1);
        assertThat(this.dom.getGlasses().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getBuyList().size(), is(2));
        assertThat(this.dom.getGlasses().get(0).getSellList().size(), is(0));
    }

    @Test
    public void whenAddTypeOrdersWithDifferentBooksThenCreateNewGlass() {
        Application order = new Application("GAZPROM", Type.ADD, Action.BUY, 45, 10);
        this.dom.orderHandler(order);
        Application order1 = new Application("Microsoft", Type.ADD, Action.SELL, 44, 10);
        this.dom.orderHandler(order1);
        assertThat(this.dom.getGlasses().size(), is(2));
        assertThat(this.dom.getGlasses().get(0).getBuyList().size(), is(1));
        assertThat(this.dom.getGlasses().get(1).getSellList().size(), is(1));
    }

    @Test
    public void whenDeleteTypeOrderThenDeleted() {
        Application order = new Application("GAZPROM", Type.ADD, Action.BUY, 45, 10);
        this.dom.orderHandler(order);
        order.setType(Type.DELETE);
        this.dom.orderHandler(order);
        assertThat(this.dom.getGlasses().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getBuyList().size(), is(0));
        assertThat(this.dom.getGlasses().get(0).getSellList().size(), is(0));
    }
    @Test
    public void whenAddOrdersThenTheySortByHighToLowPrice() {
        Application order1 = new Application("GAZPROM", Type.ADD, Action.BUY, 6, 10);
        Application order2 = new Application("GAZPROM", Type.ADD, Action.BUY, 8, 10);
        Application order3 = new Application("GAZPROM", Type.ADD, Action.BUY, 10, 10);
        Application order4 = new Application("GAZPROM", Type.ADD, Action.BUY, 11, 10);
        Application order5 = new Application("GAZPROM", Type.ADD, Action.BUY, 9, 10);
        this.dom.orderHandler(order1);
        this.dom.orderHandler(order2);
        this.dom.orderHandler(order3);
        this.dom.orderHandler(order4);
        this.dom.orderHandler(order5);
        Iterator<Application> iterator = this.dom.getGlasses().get(0).getBuyList().iterator();
        assertThat(iterator.next().getPrice(), is(11));
        assertThat(iterator.next().getPrice(), is(10));
        assertThat(iterator.next().getPrice(), is(9));
        assertThat(iterator.next().getPrice(), is(8));
        assertThat(iterator.next().getPrice(), is(6));
    }

    @Test
    public void whenMergeOrders() {
        Application orderAsk = new Application("GAZPROM", Type.ADD, Action.SELL, 10, 9);
        this.dom.orderHandler(orderAsk);
        Application orderBid = new Application("GAZPROM", Type.ADD, Action.BUY, 11, 10);
        this.dom.orderHandler(orderBid);
        assertThat(this.dom.getGlasses().get(0).getSellList().size(), is(0));
        assertThat(this.dom.getGlasses().get(0).getBuyList().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getBuyList().iterator().next().getVolume(), is(1));
        Application addToBidVolume = new Application("GAZPROM", Type.ADD, Action.BUY, 11, 5);
        this.dom.orderHandler(addToBidVolume);
        assertThat(this.dom.getGlasses().get(0).getBuyList().iterator().next().getVolume(), is(6));
        Application orderAskHighPrice = new Application("GAZPROM", Type.ADD, Action.SELL, 12, 9);
        this.dom.orderHandler(orderAskHighPrice);
        assertThat(this.dom.getGlasses().get(0).getSellList().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getBuyList().size(), is(1));
        Application orderAskLowPrice = new Application("GAZPROM", Type.ADD, Action.SELL, 10, 3);
        this.dom.orderHandler(orderAskLowPrice);
        assertThat(this.dom.getGlasses().get(0).getSellList().size(), is(1));
        assertThat(this.dom.getGlasses().get(0).getBuyList().size(), is(1));

    }

    @Test
    public void whenGlassToStringList() {
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.BUY, 70, 22));
        this.dom.orderHandler(new Application("GAZPROM", Type.ADD, Action.SELL, 220, 6));
        List<String> actual = this.dom.getGlasses().get(0).toStringList();
        List<String> expected = new ArrayList<>();
        expected.add(String.format("%5s%7s%5s", "", 220, 6));
        expected.add(String.format("%5s%7s%5s", 22, 70, ""));
        assertThat(actual, is(expected));
    }

}