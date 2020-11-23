package product;

import java.util.ArrayList;

public class Stock {

	private ArrayList<Product> listStock;
	
	public Stock() {
		this.listStock= new ArrayList<>();
	}
	
	public ArrayList<Product> getStock() {
        return listStock;
    }
}
