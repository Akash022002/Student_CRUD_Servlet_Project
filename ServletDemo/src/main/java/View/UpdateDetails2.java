package View;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import POJO.student;
import controller.UpdateData;

@WebServlet("/UpdateData")
public class UpdateDetails2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		// Now we are write the code for update the data into your database.
		response.setContentType("text/html");
		PrintWriter pt=response.getWriter();
		String sid=request.getParameter("id");
		int id=Integer.parseInt(sid);
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String country=request.getParameter("country");
		student s=new student();
		s.setId(id);
		s.setName(name);
		s.setPassword(password);
		s.setEmail(email);
		s.setAddress(address);
		s.setCity(city);
		s.setCountry(country);
		int status=UpdateData.update(s);
		if(status>0)
		{
		response.sendRedirect("SelectDetails");
		}
		else
		{
		pt.println("Unable to Update Data...");
		}
		pt.close();
	}

}
