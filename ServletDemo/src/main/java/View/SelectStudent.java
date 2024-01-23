package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import POJO.student;
import controller.SelectData;

/**
 * Servlet implementation class SelectStudent
 */
//That section was used for add an the web location of that file into the URL
@WebServlet("/SelectData")
public class SelectStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Now we are write the code for show the respective data into the main home page
		response.setContentType("text/html");
		PrintWriter pt = response.getWriter();
		//Here we are get the data from the database for show it in table.
		pt.println("<a href='index.html'>Add new Student</a>");
		pt.println("<h1>Student List</h1>");
		// Storing all the student data into List format.
		List<student>list = SelectData.getAllStudents();
		pt.println("<table border='1' cellspacing='0'>");
		pt.println("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Address</th><th>City</th><th>Country</th></tr>");
		
		// Here we are get the data from the database 
		// This data getting is in format of getdata() method 
		for(student s:list)
		{
		pt.println("<tr><td>"+s.getId()+"</td><td>"+s.getName()+"</td><td>"+s.getPassword()+"</td><td>"+s.getEmail()+"</td><td>"+s.getAddress()+"</td><td>"+s.
		getCity()+"</td><td>"+s.getCountry()+"</td><td><a href='UpdateDetails?id="+s.getId()+"'>Edit</a></td><td><a href='DeleteDetails?id="+s.getId()+"'>Delete</a></td>");
		}
		pt.println("</table>");
		pt.close();

	}

}
