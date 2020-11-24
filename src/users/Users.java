package users;

import java.util.ArrayList;

import supermarche_application.Input;

public class Users {

	private String name;
	private String password;
	private boolean isAdmin = false;
	private static ArrayList<Users> usersLogin;
	
	public Users(String name, String password, boolean isAdmin) {
		this.name = name;
		this.password = password;
		this.isAdmin = isAdmin;	
	}
	public Users(){
		usersLogin = new ArrayList<>();
		usersLogin.add(new Users("JeanPierre", "jp1234", false));	
		usersLogin.add(new Users("peter", "jpjiu178", false));	
		usersLogin.add(new Users("Pierre-Henri", "kjotwv6574", true));	
	}
 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	public static void getUuserData(String scanName, String scanPassword, boolean admin) {
		//je parcours l arraylist
		for(Users elements : usersLogin) {
			//si les noms + les pass sont == au scanners d'un utilisateur
			if(elements.getName().equals(scanName) && elements.getPassword().equals(scanPassword)) {
				if(elements.isAdmin() == true) {
					System.out.println("You are not a client please log as an administator\n");
					Input.displayMainMenu();
				}else {
					System.out.println("Welcome back " + elements.getName() + "\n");
					//menu principal client
					Input.displayCustomerMenu();
				}
			}else {
				//ajout d'un users nouveau en BDD
				
				System.out.println("You are not in our database, please create an account");
				Input.displayMainMenu();
			}
		}
	}
	
	public static void createAccount(String scanName, String scanPassword) {
		
		for(Users elements : usersLogin) {
			if(elements.getName().equals(scanName) && elements.getPassword().equals(scanPassword)) {
				System.out.println("You already exists in our database, please log\n");
				Input.displayMainMenu();
			}else {
				System.out.println("Account created, please log again as a client\n");
				Users user = new Users(scanName, scanPassword, false);
				addGuest(scanName, scanPassword, false) ;
				Input.displayMainMenu();
			}
		}
	}
	
	
	//ajouter un produit
	 public static void addGuest(String name, String password, boolean admin) {		
		 Users addUsers = new Users(name, password, admin);
        usersLogin.add(addUsers);
	 }
	
}
