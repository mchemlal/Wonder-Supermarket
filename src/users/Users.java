package users;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import product.Product;
import supermarche_application.Input;

public class Users {

	
	public static ArrayList<Customers> customers;
	public static ArrayList<Admin> admin;
	
	public Users() {
		this.customers = new ArrayList<>();
		this.admin = new ArrayList<>();
	}

	
	public static boolean getUserData(String scanName, String scanPassword) {
		 boolean matchData = false;
		customers.add(new Customers("c", "c"));
		for(int i = 0; i < customers.size(); i ++ ) {
			Customers user = customers.get(i);
			if(user.getName().equals(scanName) && user.getPassword().equals(scanPassword)) 
			{
				System.out.println("Welcome to wonder market, " + user.getName() + "\n");
				//menu principal client
				Input.displayCustomerMenu();
				matchData=true;
			}else {
				System.out.println("Please create an account");
				System.out.println(user);
				Input.displayMainMenu();
			}
		}
		return matchData;
		
	}	
	
	public static boolean getUserDataAdmin(String scanName, String scanPassword) {
		boolean matchData = false;
		//je parcours l arraylist
		admin.add(new Admin("admin", "admin"));
		for(Admin elements : admin) {
			//si les noms + les pass sont == au scanners d'un utilisateur
			if(elements.getName().equals(scanName) && elements.getPassword().equals(scanPassword) && elements.getPassword().equals("admin")) {
				System.out.println("Welcome to wonder market " + elements.getName() + "\n");
				Input.displayAdminMenu();
				matchData=true;
			}else {
					System.out.println("You don't have the rights to log as an administrator\n");
					Input.displayMainMenu();
				}
			}
		return matchData;
		}
	
	
	public static void createAccount(String scanName, String scanPassword) {
		 System.out.println("Account created\n");
		customers.add(new Customers(scanName, scanPassword));
		// addGuest(scanName, scanPassword) ;
		 //Input.displayMainMenu();

	}

	
}
