package supermarche_application;

import java.util.InputMismatchException;
import java.util.Scanner;

import product.ShoppingCart;
import product.Stock;


public class AdminMenu {
	
	static boolean isInProgressAdminMenu = false;
	
	
	public static void displayAdminMenu() {
		while(!isInProgressAdminMenu) {
			try {
			System.out.println("What do you want todo?\n"
					+ "1 - List products\n"
					+ "2 - add a product\n"
					+ "3 - return\n");
			
			Scanner scanAdmin = new Scanner(System.in);
			int choiceAdmin = scanAdmin.nextInt();
			
			if(choiceAdmin == 1) {
				Stock.displayProducts();
			}else if (choiceAdmin == 2) {
				ShoppingCart.addToStock();
			}else if (choiceAdmin == 3) {
				System.out.println("Vous retournez au menu precedent");
				MainMenu.displayMainMenu();
			}else {
				System.out.println("Veuillez entrer un chiffre entre 1 et 3");
			}
	   }catch(InputMismatchException e) {
		   System.out.println("Veuillez indiquer un chiffre entre 1 et 3");
	   }
	}
}
}
	
