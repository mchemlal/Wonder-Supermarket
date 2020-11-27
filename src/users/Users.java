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

	//recupère userName et password dans scanner, redirection menu client
	public boolean  getUserData(String dataName, String dataPassword) {
	 boolean matchDatas = false;
		customers.add(new Customers("c", "c"));
		for(int i = 0; i < customers.size(); i ++ ) {
			Customers user = customers.get(i);
			if(user.getName().equals(dataName) && user.getPassword().equals(dataPassword)) 
			{
				System.out.println("Welcome to wonder market, " + user.getName() + "\n");
				//menu principal client
				Input.displayCustomerMenu();
				 matchDatas = true;
			}else {
				System.out.println("Please create an account");
				Input.displayMainMenu();
			}
		}return matchDatas;
	}	
	
	//recupère userName et password dans scanner, redirection menu admin
	public boolean  getUserDataAdmin(String dataName, String dataPassword) {
		boolean matchDatas = false;
		//je parcours l arraylist
		admin.add(new Admin("a", "a"));
		for(Admin elements : admin) {
			//si les noms + les pass sont == au scanners d'un utilisateur
			if(elements.getName().equals("a") && /*elements.getPassword().equals(dataPassword) && */dataPassword.equals("a")) {
				System.out.println("Welcome to wonder market " + elements.getName() + "\n");
				Input.displayAdminMenu();
				 matchDatas = true;
			}else {
					System.out.println("You don't have the rights to log as an administrator\n");
					Input.displayMainMenu();
				}
			}return matchDatas;
		}
	
	//creation compte
	public static void createAccount(String scanName, String scanPassword) {
		 System.out.println("Account createdn");
		customers.add(new Customers(scanName, scanPassword));
	}

	
}
