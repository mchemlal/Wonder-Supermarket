package product;

import java.util.ArrayList;
import java.util.InputMismatchException;

import supermarche_application.Input;

public class Stock {

	//liste de produit
	private static ArrayList<Product> listStock;
	//constructeur
	public Stock() {
		this.listStock= new ArrayList<>();
		listStock.add(new Product(1,"bread", 2.50, 20));
		listStock.add(new Product(2,"milk", 1.80, 30));
		listStock.add(new Product(3,"apple", 1.10, 20));
	}
	
	public ArrayList<Product> getStock(){
		return listStock;
	}
	
	//afficher tous les produits dans la console
	public static void displayProducts() {
		for(int i = 0; i < listStock.size(); i++){
			if(listStock.get(i).getQuantity() > 0 ) {
			System.out.println(listStock.get(i).getId()+") nom : " + listStock.get(i).getName() + ",prix : "+ listStock.get(i).getPrice()+ 
					", Quantity : "+ listStock.get(i).getQuantity() + "\n");
			}
		}
	}
	
	//ajouter un produit
	 public void addProduct(int Id, String name,double price, int quantity) {		
        Product addProduct = new Product(Id, name, price, quantity);
             listStock.add(addProduct);
       }
	 
	 public void choseProductById(int scanId, int scanQuantity){
			for(Product elements : listStock){
				if(scanId == elements.getId()) {
					if(scanQuantity < elements.getQuantity()) {
						
						System.out.println("the product " + elements.getName() + " has been added to cart\n");
						ShoppingCart.addToCart(elements.getId(), elements.getName(), elements.getPrice(), scanQuantity);
						int updateQuantite = elements.getQuantity() - scanQuantity;
						elements.setQuantity(updateQuantite);
					}else {
						System.out.println("\nPlease make sure you choose the right quantity\n");
				}
			}
		}
	 }
	 
	 public static void chooseId(int scanId){
			if(scanId > listStock.size()) {
				System.out.println("\nThis product doesn't exist\n");
				
				displayProducts();
				Input.addInputToCart();	
			}else {
				
			
			}
	 }
}
