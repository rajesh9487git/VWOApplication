package utils;

public class ShoppingMarket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Item chocolate = new Item("chocolate", 11.0);
		Item bag = new Item("bag", 15.0);
		Item cake = new Item("cake", 23.0);
		Item bat = new Item("bat", 18.0);
		
		Cart cart = new Cart();
		
		cart.addItems(chocolate, 3);
		cart.addItems(bag, 1);
		cart.addItems(bat, 2);
		cart.addItems(cake, 4);
		
		
		double totalCartCost=cart.calculateCartPrice();
		
		System.out.println("The total cart cost is " +totalCartCost);
		
		

	}

}
