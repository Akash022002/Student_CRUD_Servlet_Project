package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import POJO.student;

public class UpdateData {

	public static int update(student s)
	{
	int status=0;
	try
	{
	Connection con=Connectiondata.getConnection();
	PreparedStatement pst=con.prepareStatement("update student set name=?,password=?,email=?,address=?,city=?,country=? where id=?");
	pst.setString(1, s.getName());
	pst.setString(2, s.getPassword());
	pst.setString(3, s.getEmail());
	pst.setString(4, s.getAddress());
	pst.setString(5, s.getCity());
	pst.setString(6, s.getCountry());
	pst.setInt(7, s.getId());
	status=pst.executeUpdate();
	con.close();
	}
	catch(Exception e)
	{
	}
	return status;
	}


}
