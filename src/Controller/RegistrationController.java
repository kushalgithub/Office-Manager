package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import  ConnectionUtil.*;
import DAO.RegistrationDAO;
import Model.Model_Registration;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname= request.getParameter("Firstname");
		String lastname= request.getParameter("Lastname");
		String address= request.getParameter("Address");
		String phonenumber= request.getParameter("PhoneNumber");
		String email= request.getParameter("Email");
		String username= request.getParameter("Username");
		String password= request.getParameter("Password");
		
		System.out.println(firstname);
		
		if(firstname!=null && lastname!=null && address!=null && phonenumber!=null && email!=null && username!=null ){
		
			
			
		Model_Registration modreg = new Model_Registration();
		modreg.setFirstName(firstname);
		modreg.setLastName(lastname);
		modreg.setAddress(address);
		modreg.setPhoneNumber(phonenumber);
		modreg.setPersonal_Email(email);
		modreg.setUserName(username);
		modreg.setPassword(password);
		
		
		
		
		RegistrationDAO rg = new RegistrationDAO();
		String check= null;
		try {
			 check =  rg.CheckDuplicateUser(modreg);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String msg=null;
		if(check.equals("usernameAvilable"))
		{
		 msg = rg.registerEmp(modreg);
		
		if(msg.equals("suceess")){
			request.setAttribute("Registered", "Registered Successfully!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		}
		else{
			
			request.setAttribute("Change", "Change The User Name");
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
			System.out.println("Error from dao");
		}
		}
		
	}

}
