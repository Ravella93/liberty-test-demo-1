package com.liberty.test.service;

import java.util.List;

import lombok.Data;

@Data
public class Customer {

	String name;
	List<Item> listOfItems;

	public int calculateBill() {
		int total = 0;
		for (Item item : listOfItems) {
			total += item.getPrice(item.getName());
		}
		return total;
	}
}
