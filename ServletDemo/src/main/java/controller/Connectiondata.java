package controller;

import java.sql.Connection;
import java.sql.DriverManager;

// That class was used for do the database connection via jdbc Connection driver.
public class Connectiondata {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbj.Driver");
			con=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","student");
		}
		catch(Exception e)
		{
			System.out.println("Connection was not build");
		}
		return con;
	}
}
