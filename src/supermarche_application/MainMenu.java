package supermarche_application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {


	public static void logo() {
		System.out.println(" _______________________________");
		System.out.println("|                               |");
		System.out.println("|  WELCOME TO WONDER MARKET !   |");
		System.out.println("|_______________________________|");
	}

	
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
			CustomerMenu.displayCustomerMenu();
		}
		else if(choiceUser == 2) {
			AdminMenu.displayAdminMenu();
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
}
