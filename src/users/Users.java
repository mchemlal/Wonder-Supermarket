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

	
	public static void getUserData(String scanName, String scanPassword) {
		customers.add(new Customers("customer", "customer"));
		for(int i = 0; i < customers.size(); i ++ ) {
			Customers user = customers.get(i);
			if(user.getName().equals(scanName) && user.getPassword().equals(scanPassword)) 
			{
				System.out.println("Welcome to wonder market, " + user.getName() + "\n");
				//menu principal client
				Input.displayCustomerMenu();
			}else {
				System.out.println("Please create an account");
				System.out.println(user);
				Input.displayMainMenu();
			}
		}	
	}	
	
	public static void getUserDataAdmin(String scanName, String scanPassword) {
		//je parcours l arraylist
		admin.add(new Admin("admin", "admin123"));
		for(Admin elements : admin) {
			//si les noms + les pass sont == au scanners d'un utilisateur
			if(elements.getName().equals(scanName) && elements.getPassword().equals(scanPassword) && elements.getPassword().equals("admin123")) {
					System.out.println("Welcome to wonder market " + elements.getName() + "\n");
					Input.displayAdminMenu();
			}else {
					System.out.println("You don't have the rights to log as an administrator\n");
					Input.displayMainMenu();
				}
			}
		}
	
	
	public static void createAccount(String scanName, String scanPassword) {
		 System.out.println("Account created, please log in again\n");
		customers.add(new Customers(scanName, scanPassword));
		 System.out.println(customers);
		// addGuest(scanName, scanPassword) ;
		 //Input.displayMainMenu();

}

	//ajouter un produit
	 public  void addGuest(String scanName, String scanPassword) {		
		 
	 }
}
