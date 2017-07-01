package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EmployeeList;

/**
 * Servlet implementation class AssignSalaryController
 */
@WebServlet("/AssignSalaryController")
public class AssignSalaryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSalaryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(flag.equals("admin")){
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			int empid = Integer.parseInt(request.getParameter("id"));
			
			request.setAttribute("fn", firstname);
			request.setAttribute("ln", lastname);
			request.setAttribute("id", empid);
			request.getRequestDispatcher("AssignSalary.jsp").forward(request, response);
			
			
		}
		
		
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("empid"));
		int salary = Integer.parseInt(request.getParameter("AssignSalary"));
		EmployeeList emplist = new EmployeeList();
		try {
			String msg = emplist.AssignSalary(id,salary);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("salaryAssigned", "salary successfully assigned to the employee");
		request.getRequestDispatcher("ActiveList.jsp").forward(request, response);
			}

}
