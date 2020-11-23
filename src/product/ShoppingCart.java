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
	
	public static void addToCart() {
		System.out.println("c'est ajoute au panier");
	}
	
	public static void displayCart() {
		System.out.println("Je suis le panier");
	}
	
	public static void addToStock() {
		System.out.println("produit ajouté au stock");
	}

	
	
}
