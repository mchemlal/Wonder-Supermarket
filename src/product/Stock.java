package product;

import java.util.ArrayList;

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
			System.out.println(listStock.get(i).getId()+") nom : " + listStock.get(i).getName() + ",prix : "+ listStock.get(i).getPrice()+ 
					", Quantite : "+ listStock.get(i).getQuantity() + "\n");
		}
       
    }
	
	//ajouter un produit
	 public void addProduct(int Id, String name,double price, int quantity) {		
        Product addProduct = new Product(Id, name, price, quantity);
             listStock.add(addProduct);
       }
	 
	 public void choseProductById(int scanId, int scanQuantity){
			for(Product elements : listStock){
				if(scanId == elements.getId()){
					System.out.println("this product " + elements.getName() + " has been added to cart\n");
					ShoppingCart.addToCart(elements.getId(), elements.getName(), elements.getPrice(), scanQuantity);
					int updateQuantite = elements.getQuantity() - scanQuantity;
					elements.setQuantity(updateQuantite);
				}

			}

		}
	 public void setQuantity() {
		
	 }
	 
}
