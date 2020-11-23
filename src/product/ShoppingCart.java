package product;

import java.util.ArrayList;


public class ShoppingCart {

	private ArrayList<Product> listCart;
	
	public ShoppingCart() {
		this.listCart = new ArrayList<>();
	}
	
	 public ArrayList<Product> getCart() {
	        return listCart;
	    }

}
