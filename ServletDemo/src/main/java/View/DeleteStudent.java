package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import controller.DeleteData;

@WebServlet("/DeleteData")
public class DeleteStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Now we are write the code for delete the data form database 
		// Here only the View code is available
		String sname = request.getParameter("name");
		DeleteData.delete(sname);
		response.sendRedirect("index.html");
		// Redirect to the new page after the successfully data was deleted
		
	}

}
