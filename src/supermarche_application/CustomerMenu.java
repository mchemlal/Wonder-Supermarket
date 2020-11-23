package supermarche_application;

import java.util.InputMismatchException;
import java.util.Scanner;

import product.ShoppingCart;
import product.Stock;

public class CustomerMenu {

	static boolean isInProgressCustomerMenu;
	
	public static void displayCustomerMenu() {
		
		while(!isInProgressCustomerMenu) {
			try {
		System.out.println("What do you want todo?\n"
				+ "1 - List products\n"
				+ "2 - add to cart\n"
				+ "3 - logout\n");
		
		Scanner scanCustomer = new Scanner(System.in);
		int choiceCustomer = scanCustomer.nextInt();
		
		if(choiceCustomer == 1) {
			Stock.displayProducts();
		}else if (choiceCustomer == 2) {
			ShoppingCart.addToStock();
		}else if (choiceCustomer == 3) {
			System.out.println("Vous retournez au menu precedent");
			MainMenu.displayMainMenu();
		}else {
			System.out.println("Veuillez entrer un chiffre entre 1 et 3");
		}
		}catch(InputMismatchException e) {
			System.out.println("veuillez entrer un chiffre entre 1 et 3");
		}
		}
	}
}
