package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData {

	public static int delete(String sname)
	{
	int status=0;
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/login";
        String username = "root";
        String password = "Akash@2002";

        // Establish the database connection
        Connection con = DriverManager.getConnection(url, username, password);
	PreparedStatement pst=con.prepareStatement("delete from student where name=?");
	pst.setString(1, sname);
	status=pst.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
	System.out.println(e);
	}
	return status;
	}


}
