package supermarche_application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import product.Order;
import product.ShoppingCart;
import product.Stock;
import users.Customers;
import users.Users;

public class Input {
	
	public static Stock listStock = new Stock(); 
	public static ShoppingCart listShoppinCart = new ShoppingCart();
	public static Users users = new Users();
	public static Order Allorders = new Order();
	public static Scanner scanUser = new Scanner(System.in);
	 
	
	 public static void displayMainMenu() {
			
			boolean isInProgress = false;
			System.out.println(" _______________________________");
			System.out.println("|                               |");
			System.out.println("|  WELCOME TO WONDER MARKET     |");
			System.out.println("|_______________________________|\n");
			
			System.out.println("What do you want to do?\n "
					+ "1 - Log in as client\n "
					+ "2 - Log in as an administrator\n"
					+ " 3 - Create your account\n"
					+ " 4 - Exit");
			
			while(!isInProgress) {
				try {
					
				int choiceUser = scanUser.nextInt();
					
				if(choiceUser == 1 ){
					System.out.println("Enter your login");
					String UserNameLog = scanUser.next();
					
					System.out.println("Enter your password");
					String UserPassLog = scanUser.next();
					
					//customer details checking and redirecting
					users.getUserData(UserNameLog, UserPassLog);
					break;
					}
				else if(choiceUser == 2) {
					System.out.println("Enter your login");
					String UserNameLog = scanUser.next();
					
					System.out.println("Enter your password");
					String UserPassLog = scanUser.next();
					
					//admin details checking and redirecting
					users.getUserDataAdmin(UserNameLog, UserPassLog);
					break;
					
				}else if(choiceUser == 3) {					
					System.out.println("Enter your login");
					String UserNameLog = scanUser.next();
					
					System.out.println("Enter your password");
					String UserPassLog = scanUser.next();
					
					//create account 
					users.createAccount(UserNameLog, UserPassLog);
					displayMainMenu();
					//displayCustomerMenu();
	
				}else if(choiceUser == 4) {
					System.out.println("thank you, bye");
					System.exit(1);	
				}else {
					System.out.println("please enter a number between 1 to 3");
					displayMainMenu();
				}
			
	 		}catch(InputMismatchException e){
				System.out.println("please enter a number between 1 to 3");
				
			}finally {
				scanUser.nextLine();
			}	
	 	}displayMainMenu();

	}



 
	public static void displayAdminMenu(){
    boolean isInProgressAdminMenu = false;
	while(!isInProgressAdminMenu) {
		try {
		System.out.println("What do you want todo?\n"
				+ "1 - List products\n"
				+ "2 - add a product\n"
				+ "3 - Orders checking\n"
				+ "4 - logout\n");
		
		
		int choiceAdmin = scanUser.nextInt();
		
		
		if(choiceAdmin == 1) {
				//shopping cart infos
				listStock.displayProducts();
		}else if (choiceAdmin == 2) {
				//display products 
				addProductDatas();
		}else if (choiceAdmin == 3) {
			//display all orders
			Allorders.displayGuestOrder();
			
			System.out.println("\nWhat do you want to do?\n"
								+ "p - process the order\n"
								+ "m - back to main menu\n");
				
				String AdminChoiceOrder = scanUser.next();
					
					if(AdminChoiceOrder.equals("p")) {
						
						
						if(Allorders.getOrder().isEmpty()) {
							System.out.println("\nYour order list is empty\n");
						}else {
							System.out.println("\nType the id to process the order");
							int idProcessOrder = scanUser.nextInt();
							
							//clear th selected order
							Allorders.clearOrder(idProcessOrder);
						}
					
					}else if(AdminChoiceOrder.equals("m")) {
						displayAdminMenu();
					}
			}
			else if (choiceAdmin == 4) {
				System.out.println("Back to the main menu");
				displayMainMenu();
				break;
			}else {
				System.out.println("please enter a number between 1 to 4");
			}
		}catch(InputMismatchException e) {
			System.out.println("wrong key, please try again");
			
		}finally {
			scanUser.nextLine();
		}
	}
}
	
	public static void displayCustomerMenu() {
		boolean isInProgressCustomerMenu = false;
		while(!isInProgressCustomerMenu) {
			try {
		System.out.println("What do you want todo?\n"
				+ "1 - List products\n"
				+ "2 - add to cart\n"
				+ "3 - logout\n");
		
		//display and update the shopping cart informations
		listShoppinCart.displayCart();
		int choiceCustomer = scanUser.nextInt();
		
		if(choiceCustomer == 1) {
			//display products stock list
			listStock.displayProducts();
			
		}else if (choiceCustomer == 2) {
			
			listStock.displayProducts();
			
			addInputToCart();
			//listShoppinCart.displayCart();
			
		}else if (choiceCustomer == 3) {
			System.out.println("Back to the main menu");
			displayMainMenu();
		}else {
			System.out.println("Please enter a number between 1 to 3");
		}
		}catch(InputMismatchException e) {
			System.out.println("Wrong key, please try again");
		}finally {
			scanUser.nextLine();
		}
		}
	}
	
	public static void addInputToCart() {
		
		int chooseId = 0;
		int chooseQuantity = 0;
		boolean isBuying = false;
		int idOrder = Allorders.getId();
		while(!isBuying) {
		System.out.println("Add to your cart your chosen products by tipping in the matching Id ");
		chooseId = scanUser.nextInt();
		
		try {
			System.out.println("\nChoose a quantity : ");
			chooseQuantity = scanUser.nextInt();

		}catch(InputMismatchException e){
			System.out.println("wrong key");
		}finally {
			scanUser.nextLine();
		}
		
		//check scanner and stock(id and quantity) matches
		listStock.choseProductById(chooseId, chooseQuantity);
		
		listShoppinCart.displayCart();
		
			if(listShoppinCart.getCartTotalAmount() == 0) {
				
				listStock.displayProducts();
			}else {
			System.out.println("What do you want to do?\n b - Buy your shopping cart \n r - return");
			}
			Scanner scan = new Scanner(System.in);
			String BuyOrReturn = scan.nextLine();
			
		if(BuyOrReturn.equals("b")) {
			// on genere un id pour la commande
			
			System.out.println("Thank you for buying, you will receive a email soon ");

			String GuestName = Allorders.orderGuestName(users);
			String productName = Allorders.getnameProduct(listShoppinCart);
			int orderQuantity = Allorders.getProductQuantity(listShoppinCart);
			double amountOrder =  Allorders.getTotalAmount(listShoppinCart);
			
			
			
			//after buying confirmed, create admin order
			Allorders.addAnOrder(idOrder, GuestName, productName, orderQuantity,amountOrder );
			idOrder++;
			Allorders.setId(idOrder);
			
			System.out.println(idOrder);
			
			//remove the cart items
			listShoppinCart.clearShippingCart();
			
			
			displayCustomerMenu();	
			break;

			
		}else if(BuyOrReturn.equals("r")){
			displayCustomerMenu();	
		}else {
			System.out.println("wrong key!");
		}
		}
	}

	
	public static void addProductDatas() {
		boolean isInProgressAdminDatas = false;
		
		while(!isInProgressAdminDatas) {
		String addNameProduct = "";
		double addPriceProduct = 0.00;
		int addQuantityProduct = 0;
		int addId = 4;
		
		try {
			System.out.println("insert a product name : ");
			addNameProduct = scanUser.next();
		}catch(InputMismatchException e){
			System.out.println("please enter a word");
		}finally {
			scanUser.nextLine();
		}
		
		try {
			System.out.println("insert a float price : ");
			addPriceProduct = scanUser.nextDouble();
		}
		catch(InputMismatchException e){
			System.out.println("please enter this type : 0,00");
		}finally {
			scanUser.nextLine();
		}
		
		try {
			System.out.println("insert a quantity : ");
			addQuantityProduct = scanUser.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("please enter an entire number");
		}finally {
			scanUser.nextLine();
		}

		//display product stock
		listStock.addProduct(addId, addNameProduct, addPriceProduct, addQuantityProduct);
		addId++;
		isInProgressAdminDatas = true;
		}
		System.out.println("Product added successfully!\n ");
		displayAdminMenu();

	}
	
}

