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
	public Order(int idOrder, String name, String nameProduct, int quantity, double amount) {
		this.idOrder = idOrder;
		this.name = name;
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	public Order() {
		order = new ArrayList<>();
		this.setName2(name);
		this.setNameProducts(nameProduct);
		this.setProductQuantity(quantity) ;
		this.setTotalAmount(amount) ;
	}
	
	public static int orderId(int idGenerated) {
		idOrder = idGenerated;
		return idOrder;
	}

	public String orderGuestName(Users utilisateur) {
		String getNameGuest = null;
		for(Customers CustomerName : utilisateur.customers){
			 getNameGuest = CustomerName.getName();
		}return getNameGuest;
	}
	public void setName2(String getNameGuest) {
		this.name = getNameGuest;
	}
	

	public String getnameProduct(ShoppingCart shop) {
		String getNameProduct = null;
		for(Product elements : shop.listCart){
			if(shop.listCart != null ) {
				getNameProduct = elements.getName();
			}
		}return getNameProduct;
	}
	public void setNameProducts(String getNameProduct) {
		this.nameProduct = getNameProduct;
	}

	public int getProductQuantity(ShoppingCart shop) {
		int productQuantity = 0;
		for(Product elements : shop.listCart){
			if(shop.listCart != null ) {
			productQuantity = elements.getQuantity();
			}
		}return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.quantity = productQuantity;
	}
	

	public double getTotalAmount(ShoppingCart shop) {
		double amountOrder = shop.getCartTotalAmount();
		this.amount = amountOrder;
		return amountOrder;
	}
	public void setTotalAmount(double amountOrder) {
		this.amount = amountOrder;
	}

	/*--------------------- accesseurs ------------------------*/
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameProduct() {
		return nameProduct;
	}

	public void setNameProduct(String nameProduct) {
		this.nameProduct = nameProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	/*-----------------------------------------------*/
	public  void addAnOrder(int idOrder, String getNameGuest, String getNameProduct, int productQuantity, double amountOrder){
		Order addOrder = new Order(idOrder, getNameGuest,  getNameProduct,  productQuantity,  amountOrder);
		order.add(addOrder);
	}
	
	public void displayGuestOrder() {
		for (Order eachItem : order) {
			System.out.println("\nCommande n° " + idOrder+ "\n"
							 + "Name : "  + eachItem.getName() + "\n"
							 + "Product : " + eachItem.getNameProduct()  + "\n"
							 + "Quantity : " + eachItem.getQuantity()  + "\n"
							 + "Total amount " +eachItem.getAmount() + "\n");
		}
	}
	
	public void clearShippingCart(int id) {
			order.remove(id);
	}	
}
