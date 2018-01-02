package ru.ilya.models;

import java.util.*;

public class Tracker {
	public Item[] items = new Item[100];
	private int position = 0;
	public static Random rn = new Random();
	public Item add(Item item) {
		item.setId(this.generatedId());
		this.items[position++] = item;
		return item;
	}
	public Item findById(String id) {
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
	public void update(String id ,Item item) {
		id = item.getId();
		for (int index = 0; index != position; index++) {
			if (item != null && this.items[index].getId().equals(id)) {
				this.items[index] = item;
				break;
			}
		}
	}
	public Item[] findByName(String key) {
		Item[] result = new Item[position];
		for (int i = 0; i < position; i++) {
			if (this.items[i] != null && this.items[i].getName().equals(key)) {
				result[i] = this.items[i];
				break;
			}
		}
		return result;
	}
    public Item[] findAll() {
        Item[] result = new Item[position];
        for (int i = 0; i < position; i++) {
            result[i] = this.items[i];
        }
        return result;
    }
    public void delete(Item item) {
        for (int index = 0; index != position; index++) {
            if (this.items[index].getId().equals(item.getId())) {
                System.arraycopy(this.items, index + 1, this.items, index, position - index);
                position--;
                break;
            }
        }
    }

	public Item[] getAll() {
		Item[] result = new Item[this.position];
		for (int index = 0; index != this.position; index++) {
			result[index] = this.items[index];
		}
		return result;
	}
	private String generatedId() {
		return String.valueOf(System.currentTimeMillis() + rn.nextInt());
	}
}