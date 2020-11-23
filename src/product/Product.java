package product;

public class Product {

	private int Id;
	private String name;
	private double price;
	private int quantity;
	
	public Product(int Id, String name, double price, int quantity) {
		this.Id = Id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
