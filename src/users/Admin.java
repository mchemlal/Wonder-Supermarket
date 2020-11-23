package users;

public class Admin extends Users{

	private String name;
	private String passwordAdmin;
	private int idAdmin;
	
	
	public Admin(String name, String password, int idUser, boolean isAdmin) {
		super(name, password, idUser, isAdmin);
	}

	

	
	
}
