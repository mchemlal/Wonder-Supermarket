package supermarche_application;

import java.awt.EventQueue;


public class Main {
	
	

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable(){
			
			public void run() {
				
				try {
					Input.initialization();
					}catch (Exception e) {
					e.printStackTrace();
					
				}
			}

		});
	}
}
