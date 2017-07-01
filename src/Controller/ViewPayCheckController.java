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
import DAO.PayRollDAO;
import Model.Model_PayRoll;
import Model.Model_Registration;

/**
 * Servlet implementation class ViewPayCheckController
 */
@WebServlet("/ViewPayCheckController")
public class ViewPayCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPayCheckController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(flag.equals("check")){
			HttpSession session=request.getSession(); 
			List<Model_PayRoll> paychecklist=new ArrayList<Model_PayRoll>();
			int id = Integer.parseInt(request.getParameter("id"));
			PayRollDAO pd = new PayRollDAO();
			try {
				paychecklist = pd.paycheckList(id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session.setAttribute("paychecklist", paychecklist);
			response.sendRedirect("ViewPayCheck.jsp");
			
			
			
		//	HttpSession session=request.getSession(); 
		//	List<Model_Registration> inactivelist=new ArrayList<Model_Registration>();
		//	EmployeeList emp=new EmployeeList();
		//	try {
		//	inactivelist= emp.InactiveList();
		//	//System.out.println("Size Of List:"+inactivelist.size());
		//	session.setAttribute("inactivelist", inactivelist);
		//	response.sendRedirect("InactiveList.jsp");
		//	} catch (SQLException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();

		}
		
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
