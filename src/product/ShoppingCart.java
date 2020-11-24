package product;

import java.util.ArrayList;
import java.util.List;


public class ShoppingCart {

	private static ArrayList<Product> listCart = null;
	
	//constructeur
	public ShoppingCart() {
		this.listCart = new ArrayList<>();
		listCart.add(new Product(1,"chocolate", 2.10, 2));
	}
	
	public ArrayList<Product> getCart() {
	        return listCart;
	}

	
	

	public double getCartTotalAmount() {
		double totalAmount = 0;
		for (int i = 0; i < listCart.size(); i++) {
			totalAmount = totalAmount + (listCart.get(i).getQuantity() * listCart.get(i).getPrice());
		}
		return totalAmount;
	}

	public void displayCart() {
		for(Product elements : listCart){
			if(listCart == null) {
				System.out.println("Votre panier est vide");
			}else {
			System.out.println("product : " + elements.getName() + " price: " + elements.getPrice() + "quantity: " + elements.getQuantity()+ "\n"
					+ " Montant total :" + getCartTotalAmount());
			}
		}
	}
	
	public static void addToCart(int id, String name, double price, int quantity){
		Product addProduct = new Product(id, name, price, quantity);
		listCart.add(addProduct);
	}

	
	
}
