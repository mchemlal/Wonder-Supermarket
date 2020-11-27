package product;

import java.util.ArrayList;
import java.util.List;

import supermarche_application.Input;
import users.Customers;
import users.Users;

public class Order {
	public static int idNextOrder = 1;
	public static int idOrder;
	public static ArrayList<Order> order;
	private String name;
	private String nameProduct;
	private int quantity;
	private double amount;
	
	//constructeur objet  d'un item de la commande client
	public Order(int idOrder, String name, String nameProduct, int quantity, double amount) {
		this.idOrder = idOrder;
		this.name = name;
		this.nameProduct = nameProduct;
		this.quantity = quantity;
		this.amount = amount;
	}
	
	//constructeur objet commande client
	public Order() {
		order = new ArrayList<>();
		//this.setId(idOrder);
		
		this.setName2(name);
		this.setNameProducts(nameProduct);
		this.setProductQuantity(quantity) ;
		this.setTotalAmount(amount);
	}
	
	

	/*--------------------- accesseurs ------------------------*/
	public static ArrayList<Order> getOrder() {
		return order;
	}

	public static void setOrder(ArrayList<Order> order) {
		Order.order = order;
	}
	
	public static int getId() {
			idOrder = idOrder;
		return idOrder;
	}
	public void setId(int idOrder) {
		this.idOrder = idOrder;
	}
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
	
	public void setName2(String getNameGuest) {
		this.name = getNameGuest;
	}
	public void setTotalAmount(double amountOrder) {
		this.amount = amountOrder;
	}
	public void setProductQuantity(int productQuantity) {
		this.quantity = productQuantity;
	}
	public void setNameProducts(String getNameProduct) {
		this.nameProduct = getNameProduct;
	}
	/*-----------------------------------------------*/

    //recupere nom user
	public String orderGuestName(Users utilisateur) {
		String getNameGuest = null;
		for(Customers CustomerName : utilisateur.customers){
			 getNameGuest = CustomerName.getName();
		}return getNameGuest;
	}
	
	//recupere nom product dans panier client
	public String getnameProduct(ShoppingCart shop) {
		String getNameProduct = null;
		for(Product elements : shop.listCart){
			if(shop.listCart != null ) {
				getNameProduct = elements.getName();
			}
		}return getNameProduct;
	}
	
	//recupere nom product dans panier client
	public int getProductQuantity(ShoppingCart shop) {
		int productQuantity = 0;
		for(Product elements : shop.listCart){
			if(shop.listCart != null ) {
			productQuantity = elements.getQuantity();
			}
		}return productQuantity;
	}
	
	//recupere le montant total du panier
	public double getTotalAmount(ShoppingCart shop) {
		double amountOrder = shop.getCartTotalAmount();
		this.amount = amountOrder;
		return amountOrder;
	}
	
	//on crée une nouvelle commande dans panel admin
	public  void addAnOrder(int idOrder, String getNameGuest, String getNameProduct, int productQuantity, double amountOrder){
		Order addOrder = new Order(idOrder, getNameGuest,  getNameProduct,  productQuantity,  amountOrder);
		order.add(addOrder);
	}
	
	//affichage des commandes dans l'admin
	public void displayGuestOrder() {
		for (Order eachItem : order) {
			if(eachItem.getId() >= 1) {
			System.out.println("\nCommande n° " + eachItem.getId()+ "\n"
							 + "Name : "  + eachItem.getName() + "\n"
							 + "Product : " + eachItem.getNameProduct()  + "\n"
							 + "Quantity : " + eachItem.getQuantity()  + "\n"
							 + "Total amount " +eachItem.getAmount() + "\n");
			}else {
				System.out.println("\nThere is no pending orders");
			}
		}
	}
	
	//suppression panier
	public void clearOrder(int scanid) {
		for(Order elements : order) {
			if(elements.idOrder == scanid) {
			order.remove(elements);
			System.out.println("\nOrder deleted correctly\n");
			Input.displayAdminMenu();
			System.out.println("\nWhat do you want to do?\n"
					+ "p - process the order\n"
					+ "m - back to main menu\n");
			}else {
				System.out.println("\nWrong command\n");
				Input.displayAdminMenu();
				
			}
			
			
		}
	}
	
}
