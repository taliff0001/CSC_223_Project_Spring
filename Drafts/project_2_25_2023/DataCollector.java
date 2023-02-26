package project_2_25_2023;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

//This code is borrowed from Dr. Wolf's example code for working with databases in Java
//and modified to work with this program. I have left some of the code in here but commented it out
//in case we want to implement it at some point.

public class DataCollector {

	static Connection conn = null;
	static Statement stmt = null;
	private static Scanner scan = new Scanner(System.in);

	public static Connection createConnection() {

		String user = "DBUser";
		String pass = "DBUser";
		String name = "customerdata";
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/" + name;

		System.out.println(driver);
		System.out.println(url);

		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, pass);
			System.out.println("Connection really is from : " + conn.getClass().getName());
			System.out.println("Connection successful!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
				// stmt.close();
				System.out.println("The connection was successfully closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	public static void checkConnect() {
		if (conn == null) {
			conn = createConnection();
		}
		if (stmt == null) {
			try {
				stmt = conn.createStatement();
			} catch (SQLException e) {
				System.out.println("Cannot create the statement");
			}

		}
	}

//	public static void printCookies() {
//		checkConnect();
//		String query = "SELECT * FROM cookies";
//		try {
//			stmt = conn.createStatement();
//
//			ResultSet rs = stmt.executeQuery(query);
//			System.out.println(" ");
//			System.out.println("ID  Cookie Name  Number in Stock  Cost Each");
//			
//			while (rs.next()) {
//				int id = rs.getInt("ID");
//				String cook = rs.getString("cookieName");
//				int number = rs.getInt("numInStock");
//				double cost = rs.getDouble("costEach");
//
//				System.out.println(id + "     " + cook + "       " + number + "      " + cost);
//			}
//		}
//
//		catch (SQLException e) {
//			System.out.println("SQL Exception");
//			e.printStackTrace();
//		}
//
//	}

	public static void logCustomer(Customer c) {
		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("What is the name of the cookie?");
//		String name = scan.nextLine();
//		System.out.println("How many are in stock");
//		int num = scan.nextInt();
//		System.out.println("What is the cost each?");
//		double cost = scan.nextDouble();
		
		
		String queryAdd = "INSERT INTO customerdata (customerNum, arrivalTime,"
				+ "serviceTime, location, departureTime, notes) VALUES "
				+ "(" + c.getCustNum() + "," + c.getArrivalTime() + "," + c.getServiceTime() + ",'" + c.getLane() + "'," + 
				c.getFinishTime() + ",'Notes here'" + ")";
		System.out.println(queryAdd);
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(queryAdd);

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL insert Exception");
		}		
		
	}
	
//	public static void deleteCookies() {
//		Scanner scan = new Scanner(System.in);
//		System.out.println("What is the ID number of the cookie that you wish to delete?");
//		int num = scan.nextInt();		
//		
//		String queryDelete = "DELETE FROM cookies WHERE ID = " + num; 
//		System.out.println(queryDelete);
//		try {
//			stmt = conn.createStatement();
//			int rows = stmt.executeUpdate(queryDelete);
//			if (rows==1)
//				System.out.println("That cookie was successfully deleted");
//			else
//				System.out.println("That ID was not found");
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//			System.out.println("SQL insert Exception");
//		}		
//		
//	}
//	
//	public static void findCookies() {
//		checkConnect();
//		Scanner scan = new Scanner(System.in);
//		System.out.println("What is the name of the cookie that you want?");
//		String which = scan.nextLine();
//		
//		String query = "SELECT * FROM cookies WHERE cookieName = '" + which + "'";
//		try {
//			stmt = conn.createStatement();
//
//			ResultSet rs = stmt.executeQuery(query);
//			System.out.println(query);
//			
//			boolean empty = true;
//			boolean first = true;
//			// cursor starts ABOVE first row so need a rs.next()
//			while (rs.next()) {
//				if (first) {
//					System.out.println("ID  Cookie Name  Number in Stock  Cost Each");
//					first = false;
//				}
//				int id = rs.getInt("ID");
//				String cook = rs.getString("cookieName");
//				int number = rs.getInt("numInStock");
//				double cost = rs.getDouble("costEach");
//				empty = false;
//				System.out.println(id + "     " + cook + "       " + number + "      " + cost);
//			}
//			if (empty)
//				System.out.println("There is no data with that name");
//		}
//
//		catch (SQLException e) {
//			System.out.println("SQL Exception");
//			e.printStackTrace();
//		}
//
//	}
//	
//	
//	public static void sumCookies() {
//		checkConnect();
//		Scanner scan = new Scanner(System.in);
//		NumberFormat nf = NumberFormat.getCurrencyInstance();
//		String query = "SELECT SUM(numInStock * costEach) as TOTAL_AMT FROM cookies"; 
//		try {
//			stmt = conn.createStatement();
//
//			ResultSet rs = stmt.executeQuery(query);
//			System.out.println(query);
//			while(rs.next()) {
//				double total = rs.getDouble(1);			
//				System.out.println("The total value of all inventory is " + nf.format(total));
//			}
//		}
//		catch (SQLException e) {
//			System.out.println("SQL Exception");
//			e.printStackTrace();
//		}
//
//	}
	

}
