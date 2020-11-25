package product;

import java.util.ArrayList;
import users.Customers;
import users.Users;

public class Order {

	public static int idOrder;
	public static ArrayList<Order> order;
	private String name;
	private String nameProduct;
	private int quantity;
	private double amount;
	
	//constructeur
	public Order() {
		this.order = new ArrayList<>();
		order.add(new Order());
	}
	
	public Order(int idOrder, String name, String nameProduct, int quantity, double amount) {
	}
	
	//accesseurs
	public static void setId(int idGenerated) {
		idOrder = idGenerated;
		System.out.println("id of order :" + idOrder +"\n");
	}
	public int getId() {
		return idOrder;
	}

	//METHODES TEST RECUP INFOS PANIER - commentaires à supprimer apres
	public String getName(Users utilisateur) {
		String getNameGuest = null;
		for(Customers CustomerName : utilisateur.customers){
			 getNameGuest = CustomerName.getName();
		}return getNameGuest;
	}
	public void setName(String getNameGuest) {
		this.name = getNameGuest;
	}
	
	
	public String getnameProduct(ShoppingCart shop) {
		String getNameProduct = null;
		for(Product elements : shop.listCart){
			if(shop.listCart != null ) {
				getNameProduct = elements.getName();
			//System.out.println("Produit : " + elements.getName() /* + "\nprice :  " + elements.getPrice()*/); 
			}
		}return getNameProduct;
	}
	public void setnameProduct(String getNameProduct) {
		this.nameProduct = getNameProduct;
	}
	
	
	public int getProductQuantity(ShoppingCart shop) {
		int productQuantity = 0;
		for(Product elements : shop.listCart){
			if(shop.listCart != null ) {
			productQuantity = elements.getQuantity();
			//System.out.println("Produit : " + elements.getName() /* + "\nprice :  " + elements.getPrice()*/); 
			}
		}return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.quantity = productQuantity;
	}
	
	
	public double getAmount(ShoppingCart shop) {
		double amountOrder = shop.getCartTotalAmount();
		return amountOrder;
	}
	public void setAmount(double amountOrder) {
		this.amount = amountOrder;
	}
	
	
	public static void addAnOrder(int id, String name, String nameProduct,int quantity,  double price){
		Order addOrder = new Order(id, name, nameProduct, quantity, price);
		order.add(addOrder);
		
	}
	
	public void clearShippingCart(int id) {
			order.remove(id);
	}
	
	
}
