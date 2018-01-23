package ru.job4j.ilya;

/**
 * Created by Lenovo2 on 02.11.2017.
 */
import java.util.*;

public class Tracker {

    public Item[] items = new Item[100];
    private int position = 0;
    public static Random RN = new Random();

    public void add(Item item) {
        item.setId(this.generatedId());
        this.items[position++] = item;
    }

    public Item findById(String id){
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    public void update(Item item) {
        String id;
        id = item.getId();
        for (int index = 0; index != position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = item;

                break;
            }
        }
    }
    private String generatedId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}