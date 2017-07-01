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
 * Servlet implementation class InactiveController
 */
@WebServlet("/InactiveController")
public class InactiveController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(); 
		List<Model_Registration> inactivelist=new ArrayList<Model_Registration>();
		EmployeeList emp=new EmployeeList();
		try {
		inactivelist= emp.InactiveList();
		//System.out.println("Size Of List:"+inactivelist.size());
		session.setAttribute("inactivelist", inactivelist);
		response.sendRedirect("InactiveList.jsp");
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

	}

}
}
