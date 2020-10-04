package com.liberty.test.model;

public class Item {

	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice(String name) {
		int price = 0;
		if(name.equals("John")){
			price = 100;
		}else if(name.equals("Kaif")){
			price = 400;
		}else if(name.equals("Spark")){
			price = 150;
		}else if(name.equals("Tesla")){
			price = 75;
		}			
		return price;
	}
}
