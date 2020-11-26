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
					users.getUserData(UserNameLog, UserPassLog);
					break;
					}
				else if(choiceUser == 2) {
					System.out.println("Enter your login");
					String UserNameLog = scanUser.next();
					
					System.out.println("Enter your password");
					String UserPassLog = scanUser.next();
					users.getUserDataAdmin(UserNameLog, UserPassLog);
					break;
					
				}else if(choiceUser == 3) {
					System.out.println("Enter your login");
					String UserNameLog = scanUser.next();
					
					System.out.println("Enter your password");
					String UserPassLog = scanUser.next();
					users.createAccount(UserNameLog, UserPassLog);
					displayAdminMenu();
					break;
					
				}else if(choiceUser == 4) {
					System.out.println("Au revoir");
					System.exit(1);	
					
					isInProgress=true;
					
					
				}
	
				}catch(InputMismatchException e){
				System.out.println("veuillez entrez un chiffre entre 1 et 3");
				}
				}
			}
 
	public static void displayAdminMenu() {
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
				listStock.displayProducts();
		}else if (choiceAdmin == 2) {
				addProductDatas();
		}else if (choiceAdmin == 3) {
			
			Allorders.displayGuestOrder();
			System.out.println("\nWhat do you want to do?\n"
								+ "p - process the order\n"
								+ "m - back to main menu\n");
			
			String AdminChoiceOrder = scanUser.next();
			
			if(AdminChoiceOrder.equals("p")) {
				
				System.out.println("\nType the id to process the order");
					int idProcessOrder = scanUser.nextInt();
					Allorders.clearOrder(idProcessOrder);
					System.out.println("\nOrder deleted correctly\n");
				
			}else if(AdminChoiceOrder.equals("m")) {
				displayAdminMenu();
			}
		}
		else if (choiceAdmin == 4) {
			System.out.println("Back to the main menu");
			displayMainMenu();
			break;
		}else {
			System.out.println("Veuillez entrer un chiffre entre 1 et 3");
		}
   }catch(InputMismatchException e) {
	   System.out.println("Veuillez indiquer un chiffre entre 1 et 3");
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
		
		listShoppinCart.displayCart();
		int choiceCustomer = scanUser.nextInt();
		
		if(choiceCustomer == 1) {
			listStock.displayProducts();
			
		}else if (choiceCustomer == 2) {
			
			listStock.displayProducts();
			addInputToCart();
			//listShoppinCart.displayCart();
			
		}else if (choiceCustomer == 3) {
			System.out.println("Back to the main menu");
			displayMainMenu();
		}else {
			System.out.println("Veuillez entrer un chiffre entre 1 et 3");
		}
		}catch(InputMismatchException e) {
			System.out.println("veuillez entrer un chiffre entre 1 et 3");
		}
		}
	}
	
	public static void addInputToCart() {
		
		int chooseId = 0;
		int chooseQuantity = 0;
		boolean isBuying = false;
		while(!isBuying) {
		System.out.println("Add to your cart your chosen products by tipping in the matching Id ");

		chooseId = scanUser.nextInt();
		try {
		System.out.println("Choose a quantity : ");
		chooseQuantity = scanUser.nextInt();
		
		}catch(InputMismatchException e){
			System.out.println("wrong key");
		}
		
		listStock.choseProductById(chooseId, chooseQuantity);
		listShoppinCart.displayCart();
	
			System.out.println("What do you want to do?\n b - Buy your shopping cart \n r - return");
			Scanner scan = new Scanner(System.in);
			String BuyOrReturn = scan.nextLine();
			
		if(BuyOrReturn.equals("b")) {
			// on genere un id pour la commande
			int orderIdent = 1;
			
			System.out.println("Thank you for buying, you will receive a email soon ");

			String GuestName = Allorders.orderGuestName(users);
			String productName = Allorders.getnameProduct(listShoppinCart);
			int orderQuantity = Allorders.getProductQuantity(listShoppinCart);
			double amountOrder =  Allorders.getTotalAmount(listShoppinCart);
			
			Allorders.addAnOrder(orderIdent, GuestName, productName, orderQuantity,amountOrder );
			
			//methode qui reset le panier
			listShoppinCart.clearShippingCart();
			
			
			orderIdent++;
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
		
		
		System.out.println("insert a product name : ");
		addNameProduct = scanUser.next();
		
		System.out.println("insert a float price : ");
		addPriceProduct = scanUser.nextDouble();
		
		System.out.println("insert a quantity : ");
		addQuantityProduct = scanUser.nextInt();
		

		listStock.addProduct(addId, addNameProduct, addPriceProduct, addQuantityProduct);
		addId++;
		isInProgressAdminDatas = true;
		}
		System.out.println("Product addes successfully!\n ");
		
	
	}
	
}

