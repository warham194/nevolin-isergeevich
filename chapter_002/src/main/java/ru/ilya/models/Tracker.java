package ru.ilya.models;

import java.util.*;

public class Tracker {
    public Item[] items = new Item[100];
    private int position = 0;
    public static Random RN = new Random();

      public Item add(Item item) {
     	item.setId(this.generatedId());
       this.items[position++] = item;
       return item;
    }

    protected Item findById(String id){
      	Item result = null;
      	for (Item item : items) {
      		if (item != null && item.getId().equals(id) ) {
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
	  String generatedId() {
    	return String.valueOf(System.currentTimeMillis() + RN.nextInt());
	  }
 }