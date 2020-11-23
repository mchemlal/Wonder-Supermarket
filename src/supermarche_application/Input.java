package supermarche_application;

import java.util.InputMismatchException;
import java.util.Scanner;

import product.ShoppingCart;
import product.Stock;

public class Input {
	
	
	public static void initialization() {
		
		displayMainMenu();		
		
	}
	static Stock listStock = new Stock(); 
	
	public static void displayMainMenu() {
		
		boolean isInProgress = false;
		while(!isInProgress) {
			try {
		System.out.println(" _______________________________");
		System.out.println("|                               |");
		System.out.println("|  WELCOME TO WONDER MARKET     |");
		System.out.println("|_______________________________|\n");
		
		System.out.println("What do you want to do?\n "
				+ "1 - Log in as client\n "
				+ "2 - Log in as an administrator\n"
				+ " 3 - Exit\n");
		Scanner scanUser = new Scanner(System.in);
		int choiceUser = scanUser.nextInt();
			
		if(choiceUser == 1) {
			displayCustomerMenu();
		}
		else if(choiceUser == 2) {
			displayAdminMenu();
		}
		else if(choiceUser == 3) {
			System.out.println("Au revoir");
			System.exit(0);
		}else {
			System.out.println("Veuillez entrer un chiffre entre 1 et 3");
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
				+ "3 - return\n");
		
		Scanner scanAdmin = new Scanner(System.in);
		int choiceAdmin = scanAdmin.nextInt();
		
		
		if(choiceAdmin == 1) {
			listStock.displayProducts();
		}else if (choiceAdmin == 2) {
			
			addProductDatas();
			
			
		}else if (choiceAdmin == 3) {
			System.out.println("Vous retournez au menu precedent");
			displayMainMenu();
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
		
		Scanner scanCustomer = new Scanner(System.in);
		int choiceCustomer = scanCustomer.nextInt();
		
		if(choiceCustomer == 1) {
			listStock.displayProducts();
		}else if (choiceCustomer == 2) {
			ShoppingCart.addToStock();
		}else if (choiceCustomer == 3) {
			System.out.println("Vous retournez au menu precedent");
			displayMainMenu();
		}else {
			System.out.println("Veuillez entrer un chiffre entre 1 et 3");
		}
		}catch(InputMismatchException e) {
			System.out.println("veuillez entrer un chiffre entre 1 et 3");
		}
		}
	}
	
	
	public static void addProductDatas() {
		boolean isInProgressAdminDatas = false;
		while(!isInProgressAdminDatas) {
		Scanner scanDatas = new Scanner(System.in);
		String addNameProduct = "";
		double addPriceProduct = 0.00;
		int addQuantityProduct = 0;
		
		
		System.out.println("insert a product name : ");
		addNameProduct = scanDatas.next();
		
		System.out.println("insert a float price : ");
		addPriceProduct = scanDatas.nextDouble();
		
		System.out.println("insert a quantity : ");
		addQuantityProduct = scanDatas.nextInt();
		

		listStock.addProduct(addNameProduct, addPriceProduct, addQuantityProduct);
		isInProgressAdminDatas = true;
		}
		System.out.println("Product addes successfully!\n ");
	}
	
}

