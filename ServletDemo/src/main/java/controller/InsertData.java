package controller;
import java.sql.*;

import POJO.student;
public class InsertData {
	public static int save(student s)
	{
			int status=0;
			//Connection con = null;
			//con=Connectiondata.getConnection();
			
			try 
			{
				Class.forName("com.mysql.cj.jdbc.Driver");

	            // Database URL, username, and password
	            String url = "jdbc:mysql://localhost:3306/login";
	            String username = "root";
	            String password = "Akash@2002";

	            // Establish the database connection
	            Connection con = DriverManager.getConnection(url, username, password);
				String query="insert into student(name,password,email,address,city,country) values(?,?,?,?,?,?)";
				PreparedStatement pst;
					pst = con.prepareStatement(query);
					pst.setString(1, s.getName());
					pst.setString(2, s.getPassword());
					pst.setString(3, s.getEmail());
					pst.setString(4, s.getAddress());
					pst.setString(5, s.getCity());
					pst.setString(6, s.getCountry());
					status=pst.executeUpdate();
					con.close();
			} 
			catch (Exception e) 
			{
					System.out.println(e);
			}
			return status;
	}
}
