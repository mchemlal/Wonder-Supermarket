package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.TableColumnModel;

import com.sun.jdi.event.Event;

import product.Order;
import product.ShoppingCart;
import product.Stock;
import supermarche_application.Input;
import users.Users;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.TableColumnModel;

public class Window extends JFrame {
	 
	private static final long serialVersionUID = 1L;
	public static Stock listStock = new Stock(); 
	public static ShoppingCart listShoppinCart = new ShoppingCart();
	public static Users users = new Users();
	public static Order Allorders = new Order();
	public static Scanner scanUser = new Scanner(System.in);

	public Window() {

		/*********************************************/
		/********* Configuration of JFrame ***********/
		/*********************************************/
		super("Wonder Supermarket");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);

		/***********************************************************/
		/***************** Configuration of JPanel *****************/
		/***********************************************************/

		JPanel paneStart = new JPanel();
		JPanel paneCustomer = new JPanel();
		JPanel paneAdminStock = new JPanel();
		JPanel paneAdminOrder = new JPanel();
		
		
		this.add(paneStart);
		this.add(paneCustomer);
		this.add(paneAdminStock);
		this.add(paneAdminOrder);

		setContentPane(paneStart);
		paneCustomer.setBackground(Color.ORANGE);
		paneAdminStock.setBackground(Color.BLUE);
		paneAdminOrder.setBackground(Color.BLUE);

		/***********************************************************/
		/************** Configuration of Layout ********************/
		/***********************************************************/

		paneStart.setLayout(new FlowLayout(FlowLayout.CENTER));
		paneCustomer.setLayout(new FlowLayout(FlowLayout.CENTER));
		paneAdminStock.setLayout(new FlowLayout(FlowLayout.CENTER));
		paneAdminOrder.setLayout(new FlowLayout(FlowLayout.CENTER));

		/***********************************************************/
		/********* Configuration Components of Panel ***************/
		/***********************************************************/

		// PANEL START
		JLabel labelMainMenu = new JLabel("Welcome to the Wonder Supermarket");
		labelMainMenu.setPreferredSize(new Dimension(500,200));
		labelMainMenu.setFont(new Font("Courier New ", Font.BOLD, 25));
		
		JLabel login = new JLabel("Login : ");
		login.setFont(new Font("Courier New ", Font.BOLD, 20));
		
		JTextField textFieldLogin = new JTextField();
		textFieldLogin.setColumns(35);

		JPasswordField textFieldPassword = new JPasswordField();
		textFieldPassword.setColumns(35);

		JButton buttonCreateAnAccount = new JButton();
		buttonCreateAnAccount.setText("Create an account");

		JButton buttonValidateLogin = new JButton();
		buttonValidateLogin.setText("Validate");

		JButton buttonExitButton = new JButton();
		buttonExitButton.setText("Exit");
		
		JLabel space = new JLabel();
		space.setPreferredSize(new Dimension(900,0));
		
		
//--------------

		paneStart.add(labelMainMenu);
		//paneStart.add(login);
		paneStart.add(textFieldLogin);
		paneStart.add(textFieldPassword);
		paneStart.add(space);
		paneStart.add(buttonCreateAnAccount);
		paneStart.add(buttonValidateLogin);
		paneStart.add(buttonExitButton);
		
		// PANEL CUSTOMER
		JLabel labelCustomer = new JLabel();
		labelCustomer.setPreferredSize(new Dimension(800, 600));
		labelCustomer.setForeground(Color.white);
		labelCustomer.setText("Welcome to Wonder Supermarket, feel free to enjoy our delights !");

		String[] chooseItemCustomer = {"bread", "milk", "pomme"};
		JComboBox comboBoxProductsListCustomer = new JComboBox(chooseItemCustomer); // Liste de produits
		comboBoxProductsListCustomer.setSelectedIndex(2);

		JLabel labelproductQuantity = new JLabel();
		labelproductQuantity.setText("Choose your quantity : ");
		JTextField textProductQuantity = new JTextField();
		textProductQuantity.setColumns(29);
		JTextArea textAreaDisplayProduct = new JTextArea(); // Ajouter un produit
		textAreaDisplayProduct.setColumns(29);

		JButton buttonAddProductToCart = new JButton();
		buttonAddProductToCart.setText("Add to your cart");

		JLabel labelDisplayCart = new JLabel();
		labelDisplayCart.setText("Your shopping cart : ");
		JTextArea textAreaDisplayCart = new JTextArea(10, 10);

		JButton buttonBuyYourShoppingCart = new JButton();
		buttonBuyYourShoppingCart.setText("Buy");

		JButton buttonDeleteYourShoppingCart = new JButton();
		buttonDeleteYourShoppingCart.setText("Delete");


		// PANEL ADMINISTRATOR STOCK
		JLabel labelAdmin = new JLabel();
		labelAdmin.setPreferredSize(new Dimension(800, 600));
		labelAdmin.setForeground(Color.white);
		labelAdmin.setText("This is the admininistrator interface");

		String[] chooseEachItemAdmin = {"bread", "milk", "pomme"};
		JComboBox comboBoxChooseItemAdmin = new JComboBox(chooseEachItemAdmin); // Liste de produits
		comboBoxChooseItemAdmin.setSelectedIndex(2);

		JLabel labelChooseQuantityAdmin = new JLabel();
		labelChooseQuantityAdmin.setText("Quantity : ");
		JTextField textChooseQuantityAdmin = new JTextField();
		textChooseQuantityAdmin.setColumns(29);

	
		
		
		buttonValidateLogin.addActionListener(new ActionListener() {
		
        public void actionPerformed(ActionEvent e) {
        String pass = new String(textFieldPassword.getPassword());
        
        	if(users.getUserData(textFieldLogin.getText(), pass) );{
        		setContentPane(paneCustomer);
        		revalidate();
        	}
        	if(users.getUserDataAdmin(textFieldLogin.getText(),pass) ) {
        		setContentPane(paneAdminStock);
        		revalidate();
        	}
        	
        }
        
	});

	
	}	
}
