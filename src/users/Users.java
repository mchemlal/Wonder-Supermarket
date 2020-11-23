package users;

import java.util.ArrayList;

public abstract class Users {

	private String name;
	private String password;
	private int idUser;
	private boolean isAdmin;
	private ArrayList<Users> registerUsers;
	
	public Users(String name, String password, int idUser, boolean isAdmin) {
		this.name = name;
		this.password = password;
		this.idUser = idUser;
		this.isAdmin = isAdmin;
		this.registerUsers = new ArrayList<>();
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
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	
}
