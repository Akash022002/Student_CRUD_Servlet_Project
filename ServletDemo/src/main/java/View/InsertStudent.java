package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import POJO.student;
import controller.InsertData;

/**
 * Servlet implementation class InsertStudent
 */
@WebServlet("/InsertData")
public class InsertStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 // Here we write the code for add an the data into the database into the by using the insert query.
		response.setContentType("text/html");
		// This was used for get the data from the user input
		PrintWriter pt = response.getWriter();
		
		String name,email,password,city,address;
		
		// Here we have to get the data form the front page of the inde.html
		name = request.getParameter("name");
		email = request.getParameter("email");
		password = request.getParameter("password");
		city = request.getParameter("city");
		address = request.getParameter("address");
		
		// Create a object for add the data into the database
		student s = new student();
		s.setName(name);
		s.setEmail(email);
		s.setPassword(password);
		s.setCity(city);
		s.setAddress(address);
		// Check the condition for status of the data insert or not in database.
		int status = InsertData.save(s);
		if(status>0)
		{
			// That was shown alert of the data inserted or not
			pt.println("<h3>Record saved Successfully...........</h3>");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		else {
			pt.println("<h1>Failed to insert the record.......</h1>");
		}
		pt.close();
	}

}
