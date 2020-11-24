package product;

import java.util.ArrayList;


public class ShoppingCart {

	private ArrayList<Product> listCart;
	
	//constructeur
	public ShoppingCart() {
		this.listCart = new ArrayList<>();
	}
	
	public ArrayList<Product> getCart() {
	        return listCart;
	}

	
	public void displayCart() {
		for(Product elements : listCart){
			System.out.println("product : " + elements.getName() + " price: " + elements.getPrice() + "quantity: " + elements.getQuantity());
			}
	}

	public double getCartTotalAmount() {
		double totalAmount = 0;
		for (int i = 0; i < listCart.size(); i++) {
			totalAmount = totalAmount + (listCart.get(i).getQuantity() * listCart.get(i).getPrice());
		}
		return totalAmount;
	}


	public static void addToStock() {
		System.out.println("produit ajouté au stock \n");
	}

	public void addToCart(int Id, String name, double price, int quantity){
		Product addProduct = new Product(Id, name, price, quantity);
		listCart.add(addProduct);
	}

	public void choseProductById(int scan){
		for(Product elements : listCart){
			if(elements.getId() == scan){
				System.out.println("this product " + elements.getName() + "has been added to cart \n");
				addToCart(elements.getId(), elements.getName(), elements.getPrice(), elements.getQuantity());
			}
		}

	}
	
}
