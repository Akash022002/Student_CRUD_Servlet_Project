package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import controller.SelectData;
import POJO.student;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// Here we are write the code for update the data from the database by getting the input vis user.
		PrintWriter pt = response.getWriter();
		// From here we print the updated code on the webpage
		pt.println("<h1>Updated Student data</h1>");
		// We get the id for delete the data of that specific id from the database.
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);     // Typecasting that id from String to integer format
		
		student s = SelectData.getStudentByid(id);
		pt.println("<form action='UpdateDetails2' method='post'>");
		pt.println("<table>");
		pt.println("<tr><td><input type='hidden' name='id' value='"+s.getId()+"'></td></tr>");
		pt.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+s.getName()+"'/></td></tr>");
		pt.println("<tr><td>Password:</td><td><input type='password' name='password' value='"+s.getPassword()+"'/></td></tr>");
		pt.println("<tr><td>Email:</td><td><input type='email' name='email' value='"+s.getEmail()+"'/></td></tr>");
		pt.println("<tr><td>Address:</td><td><input type='text' name='address' value='"+s.getAddress()+"'/></td></tr>");
		pt.println("<tr><td>City:</td><td>");
		pt.println("<select name='city'>");
		pt.println("<option>Pune</option>");
		pt.println("<option>Mumbai</option>");
		pt.println("<option>Pimpri</option>");
		pt.println("<option>Bhosari</option>");
		pt.println("</select>");
		pt.println("</td></tr>");
		pt.println("<tr><td>Country:</td><td>");
		pt.println("<select name='country'>");
		pt.println("<option>India</option>");
		pt.println("<option>Australia</option>");
		pt.println("<option>Japan</option>");
		pt.println("<option>America</option>");
		pt.println("</select>");
		pt.println("</td></tr>");
		pt.println("</table>");
		pt.println("<input type='submit' value='Edit & Submit'>");
	}

}
