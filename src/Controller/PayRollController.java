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
import DAO.LeaveDAO;
import DAO.PayRollDAO;
import Model.Model_PayRoll;
import Model.Model_Registration;

/**
 * Servlet implementation class PayRollController
 */
@WebServlet("/PayRollController")
public class PayRollController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayRollController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		//int empid = Integer.parseInt(request.getParameter("id"));
		//String firstname = request.getParameter("firstname");
		//String lastname = request.getParameter("lastname");
		//String address = request.getParameter("address");
		//String email = request.getParameter("email");
		
		if(flag.equals("pay")){
			//String flag = request.getParameter("flag");
			int empid = Integer.parseInt(request.getParameter("id"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			int salary=0;
			EmployeeList emplist = new EmployeeList();	
			try {
				 salary=emplist.TotalSalary(empid);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		
		request.setAttribute("id", empid);
		request.setAttribute("fn",firstname);
		request.setAttribute("ln",lastname);
		request.setAttribute("add",address);
		request.setAttribute("email",email);
		request.setAttribute("salary",salary);
		
		request.getRequestDispatcher("/PayDetails.jsp").forward(request, response);
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		
		else if(flag.equals("payd")){
			HttpSession session=request.getSession(); 
			List<Model_Registration> activelist=new ArrayList<Model_Registration>();
			EmployeeList emp=new EmployeeList();
			try {
			activelist= emp.ActiveList();
			//System.out.println("Size Of List:"+inactivelist.size());
			session.setAttribute("activelist", activelist);
			response.sendRedirect("PayRollList.jsp");
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		//doGet(request, response);
		}
		}	
			
			
		}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int salary = Integer.parseInt(request.getParameter("salary"));
		int empid = Integer.parseInt(request.getParameter("empid"));
		String month = request.getParameter("month");
		int year = Integer.parseInt(request.getParameter("year"));
		
		Model_PayRoll modpay = new Model_PayRoll();
		modpay.setEmp_Id(empid);
		modpay.setMonth(month);
		modpay.setYear(year);
		modpay.setMonth_Salary(salary);
		
		PayRollDAO pd = new PayRollDAO();
		String msg;
		msg= pd.addSalary(modpay);
		if(msg.equals("suceess")){
			
			request.setAttribute("paid", "Salary successfully added.");
			request.getRequestDispatcher("admin.jsp").forward(request, response);

			
		}
		else{
			request.setAttribute("fail", "Failed to add Salary.");
			request.getRequestDispatcher("PayDetails.jsp").forward(request, response);

		}
		
		LeaveDAO ld = new LeaveDAO();
		try {
			ld.forwardLeaves(empid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
