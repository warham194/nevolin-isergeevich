package ru.ilya.models;

import java.util.*;

public class Tracker {
	private final ArrayList<Item> items = new ArrayList<>();
	public static Random rn = new Random();
	public Item add(Item item) {
		item.setId(this.generatedId());
		items.add(item);
		return item;
	}
	public Item findById(String id) {
		Item result = null;
		for (Item item : items) {
			if (item.getId().equals(id)) {
				result = item;
				break;
			}
		}
		return result;
	}
	public void update(Item item) {
		for (Item upItem : this.items) {
			if (upItem != null && upItem.getId().equals(item.getId())) {
				upItem.setCreate(item.getCreate());
				upItem.setDesc(item.getDescription());
				upItem.setName(item.getName());
			}
		}

	}

	public ArrayList<Item> findByName(String key) {
		ArrayList<Item> findname = new ArrayList<>();
		for (Item a : items) {
			if (a.getName().equals(key)) {
				findname.add(a);
			}
		}
		return findname;
	}
	public ArrayList<Item> findAll() {
		return this.items;
    }
    public void delete(Item item) {
		Item vspomogatelniyItem;
		Iterator<Item> item1 = this.items.iterator();
		while (item1.hasNext()) {
			vspomogatelniyItem = item1.next();
			if (vspomogatelniyItem.getId().equals(item.getId())) {
				item1.remove();
			}
		}
    }

	 public List<Item> getAll() {
		 List<Item> result = new ArrayList<>();
		 int q = 0;
		for (Item a : items) {
			result.add(items.get(q));
			q++;
		}
		return result;
	}
	private String generatedId() {
		return String.valueOf(System.currentTimeMillis() + rn.nextInt());
	}
}