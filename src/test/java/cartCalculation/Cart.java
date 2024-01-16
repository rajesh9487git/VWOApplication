package cartCalculation;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<Item> cart = new ArrayList<Item>();

	public void addCartItems(Item item, int quantity) {

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
