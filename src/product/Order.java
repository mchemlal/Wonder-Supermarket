package product;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {

	public static int idOrder;
	public static HashMap<Integer, Product> order;
	
	//constructeur
	public Order() {
		this.order = new HashMap<Integer, Product>() ;
	}
	
	
	//accesseurs
	public int getIdOrder() {
		return idOrder;
	}


	public HashMap<Integer, Product> getOrder() {
		return order;
	}

	public void setOrder(HashMap<Integer, Product> order) {
		this.order = order;
	}


	//cree une entre de tableau
	public static  void createOrder(ShoppingCart shop){
		for(Product itemCart : shop.listCart) {
			order.put(idOrder, itemCart);
			
		}
	}
	//on  boucle sur le hashmap commande client
	public void displayOrder() {
		//for(HashMap.Entry<Integer, Product> line : order.entrySet()) {
		
		order.entrySet().forEach((line) -> {
			System.out.println("\n" + line.getKey() + " - " + line.getValue().getName() + "\n");
		});
	}
	
	public static void generateId(int idGenerated) {
		idOrder = idGenerated;
	}
}
