package com.qa.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.qa.jdbc.domain.Customer;

public class TestingJDBC {

	// LOGIN DETAILS
	String jdbcConnectionUrl;
	String username;
	String password;

	public TestingJDBC(String jdbcConnectionUrl, String username, String password) {
		super();
		this.jdbcConnectionUrl = jdbcConnectionUrl;
		this.username = username;
		this.password = password;
	}

	// TO CONNECT TO SQL DATABASE
	public void testConnection() {
		Connection conn = null;

		try {
			System.out.println("Trying database connection...");
			conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
			System.out.println("Connection successful");
		}

		catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}

	// CREATE

	public void create(Customer customer) {

		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = conn.createStatement()) {

			statement.executeUpdate("INSERT INTO customer(first_name, last_name, email) VALUES('"
					+ customer.getFirstName() + "','" + customer.getLastName() + "','" + customer.getEmail() + "')");
			System.out.println("Customer created.");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// CREATE USING PREPARED STATEMENT- avoids SQL ejection
	public void createPrepared(Customer customer) {

		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statement = conn.prepareStatement("INSERT INTO customer (first_name, last_name, email) VALUES (?,?,?)")) {

			// Updates ? placeholders
			statement.setString(1, customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.executeUpdate();

			System.out.println("Customer created.");
		}

		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// READ FROM RESULT SET METHOD USED IN READ ALL AND READ BY ID METHODS
	public Customer customerFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("id");
		String firstName = resultSet.getString("first_name");
		String lastName = resultSet.getString("last_name");
		String email = resultSet.getString("email");
		return new Customer(id, firstName, lastName, email);
	}

	// READ ALL
	public List<Customer> readAll() {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customer")) {

			List<Customer> customers = new ArrayList<>();
			while (resultSet.next()) {
				customers.add(customerFromResultSet(resultSet));
			}
			return customers;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// READ BY ID
	public Customer readCustomerByID(int id) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = conn.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM customer WHERE id = " + id)) {

			resultSet.next();
			return customerFromResultSet(resultSet);

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return null;
	}

	// UPDATE

	public Customer update(Customer customer) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = conn.createStatement()) {

			statement.executeUpdate("UPDATE customer SET first_name = '" + customer.getFirstName() + "', last_name = '"
					+ customer.getLastName() + "', email = '" + customer.getEmail() + "' WHERE id = "
					+ customer.getId());
			System.out.println("Customer has successfully been updated to: ");
			return readCustomerByID(customer.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	//UPDATE WITH PREPARED STATEMENT
	
	public Customer updatePrepared(Customer customer) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				PreparedStatement statement = conn.prepareStatement("UPDATE customer SET first_name = ?, last_name = ?, email = ? WHERE id = ?")) {

			statement.setString(1,  customer.getFirstName());
			statement.setString(2, customer.getLastName());
			statement.setString(3, customer.getEmail());
			statement.setInt(4, customer.getId());
			
			statement.executeUpdate();
			
			System.out.println("Customer has successfully been updated to: ");
			return readCustomerByID(customer.getId());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// DELETE

	public void delete(int id) {
		try (Connection conn = DriverManager.getConnection(jdbcConnectionUrl, username, password);
				Statement statement = conn.createStatement()) {

			statement.executeUpdate("DELETE FROM customer WHERE id = " + id);
			System.out.println("Customer with id = " + id + " has been deleted.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
