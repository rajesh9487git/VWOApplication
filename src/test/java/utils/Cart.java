package utils;

import java.util.*;

public class Cart {

	private List<Item> cart=new ArrayList<Item>();;

//	public Cart() {
//
//		this.cart = new ArrayList<Item>();
//	}

	public void addItems(Item item, int quantity) {

		for (int i = 0; i < quantity; i++) {

			cart.add(item);
		}

	}

	public double calculateCartPrice() {

		double totalCost = 0;

		for (Item item : cart) {

			totalCost = totalCost + item.getPrice();
		}
		return totalCost;
	}

}
