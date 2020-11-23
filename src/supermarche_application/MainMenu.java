package supermarche_application;

public class MainMenu {

	
	public static void logo() {
		System.out.println(" _______________________________");
		System.out.println("|                               |");
		System.out.println("|  WELCOME TO WONDER MARKET !   |");
		System.out.println("|_______________________________|");
	}
	
	public static void displayMainMenu() {
		
		System.out.println("What do you want to do?\n "
				+ "1 - Log in as client\n "
				+ "2 - Log in as an administrator\n"
				+ " 3 - Exit\n");
	}

}
