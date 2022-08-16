package com.qa.jdbc;

import java.util.Scanner;

import com.qa.jdbc.domain.Customer;

public class Runner {
	public static void main(String[] args) {
		// CONNECT
		TestingJDBC myJDBC = new TestingJDBC("jdbc:mysql://localhost:3306/julyenabledb", "root", "pass");
		// myJDBC.testConnection();

		// MAIN INTERFACE
		Scanner scan = new Scanner(System.in);

		boolean loop = true;

		while (loop) {
			System.out.println("\n");
			System.out.println("---------------------MENU---------------------");
			System.out.println("----Create---Read---Update---Delete---Exit----");
			System.out.println("------c--------r-------u-------d-------e------");
			String request = scan.nextLine();

			// CREATE
			if (request.contains("c")) {
				System.out.println("----------Create Request: Enter First Name----------");
				String newfirstname = scan.nextLine();
				System.out.println("-------------------Enter Last Name-------------------");
				String newlastname = scan.nextLine();
				System.out.println("-------------------Enter Email-------------------");
				String newemail = scan.nextLine();
				Customer newcus = new Customer(newfirstname, newlastname, newemail);
				myJDBC.createPrepared(newcus);
			}

			// READ
			if (request.contains("r")) {
				System.out.println("----------Read all or by ID?----------");
				System.out.println("-----------[all]-------[id]-----------");
				String readrequest = scan.nextLine();
				if (readrequest.contains("all")) {
					System.out.println(myJDBC.readAll());
				}

				if (readrequest.contains("id")) {
					System.out.println("----------Search Request: Enter ID----------");
					Integer newid = scan.nextInt();
					System.out.println(myJDBC.readCustomerByID(newid));
				}
			}

			// UPDATE
			if (request.contains("u")) {
				System.out.println("--Update Request: Enter ID of The Record You Wish To Replace--");
				Integer updateId = scan.nextInt();
				scan.nextLine();
				System.out.println("-------------------Enter Updated First Name-------------------");
				String updateFirstName = scan.nextLine();
				System.out.println("-------------------Enter Updated Last Name-------------------");
				String updateLastName = scan.nextLine();
				System.out.println("-------------------Enter Email-------------------");
				String updateEmail = scan.nextLine();
				Customer updateCus = new Customer(updateId, updateFirstName, updateLastName, updateEmail);
				System.out.println(myJDBC.update(updateCus));
			}

			// DELETE
			if (request.contains("d")) {
				System.out.println("--Delete Request: Enter ID of The Record You Wish To Delete--");
				Integer deleteId = scan.nextInt();
				myJDBC.delete(deleteId);
			}

			// EXIT
			if (request.contains("e")) {
				System.out.println("You have chosen to exit the database input system.");
				loop = false;
			}
		}
		// CREATE
		// Customer jane = new Customer("Jane", "Doe", "janedoe@gmail.com");
		// myJDBC.create(jane);
		// myJDBC.createPrepared(jane);

		// READ
		// System.out.println(myJDBC.readAll());
		// System.out.println(myJDBC.readCustomerByID(8));

		// UPDATE
		// Customer janeupdate = new Customer(8, "Jane", "Does", "janedoes@gmail.com");
		// System.out.println(myJDBC.update(janeupdate));
		// System.out.println(myJDBC.updatePrepared(janeupdate));

		// DELETE - Deletes row at index value
		// myJDBC.delete(7);
	}
}
