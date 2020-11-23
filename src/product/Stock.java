package product;

import java.util.ArrayList;

public class Stock {

	private static ArrayList<Product> listStock;
	
	public Stock() {
		this.listStock= new ArrayList<>();
		listStock.add(new Product("bread", 2.50, 20));
		listStock.add(new Product("milk", 1.80, 30));
		
	}
	
	public static void displayProducts() {
		Stock stock =new Stock();
		for(Product elements : listStock){
			System.out.println("nom : " + elements.getName() + ",prix : "+ elements.getPrice()+ ", Quantite : "+ elements.getQuantity() );
       
    }
	
	
}
}