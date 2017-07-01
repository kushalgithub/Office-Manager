package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.EmployeeList;
import Model.Model_Registration;

/**
 * Servlet implementation class ListManagerController
 */
@WebServlet("/ListManagerController")
public class ListManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		HttpSession session=request.getSession(); 

   		String flag = request.getParameter("flag");
   		System.out.println(flag);
   		if(flag.equals("manager")){
   		Model_Registration modreg = new Model_Registration();
   		String id=(request.getParameter("id"));
   		String firstname=request.getParameter("firstname");
   		//System.out.println(firstname);
   		String lastname = request.getParameter("lastname");
   		//System.out.println(lastname);
   		String address = request.getParameter("address");
   		//System.out.println(address);
   		String email = request.getParameter("email");
   		//System.out.println(email);
   		session.setAttribute("id", id);
   		session.setAttribute("firstname", firstname);
   		session.setAttribute("lastname", lastname);
   		session.setAttribute("address", address);
   		session.setAttribute("email", email);
   		List<Model_Registration> managerlist=new ArrayList<Model_Registration>();
   		//register register=new register();
   		modreg.setIsActive(1);
   		EmployeeList list= new EmployeeList();
   		try {
   		managerlist=EmployeeList.ActiveList();
   		session.setAttribute("managerlist", managerlist);
   		response.sendRedirect("AssignManager.jsp");
   		} catch (SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   		}
   		}


	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		System.out.println(id);
		String managerid = request.getParameter("ActiveEmployeeList");
		System.out.println(managerid);
		EmployeeList list = new EmployeeList();
		try {
			list.assignmanager(id,managerid);
			request.setAttribute("ManagerAssigned", "Manager Successfully assigned to the Employee.");
			request.getRequestDispatcher("/admin.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
