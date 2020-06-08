package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String nameClient = sc.next();
		String txt1 = sc.next();
		System.out.print("E-mail: ");
		String emailClient = sc.next();
		String txt2 = sc.next();
		System.out.print("Birthdate: (DD/MM/YYYY)");
		Date birthdateClient = sdf.parse(sc.next());
		Client client = new Client(nameClient, emailClient, birthdateClient);
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		String txt3 = sc.next();
		Date date = new Date();
		Order order = new Order(date, status , client);
		
		System.out.println("How many itens to this order?");
		int itens = sc.nextInt();
		
		for(int i = 1; i < itens; i++) {
			System.out.println("Enter #" +itens + " item data: ");
			System.out.print("Product Name: ");
			String nameProduct = sc.next();
			System.out.print("Product price: ");
			double priceProduct = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			double totalPrice =+ priceProduct;
			Product product = new Product(nameProduct, priceProduct);
			OrderItem ordIt = new OrderItem(quantity, totalPrice, product);
			order.addItem(ordIt);
		}
		
		System.out.println(order);
		
	}

}
