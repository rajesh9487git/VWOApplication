package cartCalculation;

public class SuperMart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Item chocko = new Item("chocko", 5.0);
		Item honey = new Item("honey", 5.0);

		Cart cart = new Cart();

		cart.addCartItems(honey, 1);
		cart.addCartItems(chocko, 1);

		System.out.println(cart.calculateCartPrice());

	}

}
