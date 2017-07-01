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
import Model.Model_LeaveRequest;
import Model.Model_PayRoll;

/**
 * Servlet implementation class AssignBonusController
 */
@WebServlet("/AssignBonusController")
public class AssignBonusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignBonusController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(flag.equals("manager")){
			HttpSession session=request.getSession();
			int id = (int) session.getAttribute("id");
			System.out.println(id);
			 Model_PayRoll modpay = new Model_PayRoll();
			 //modlea.setEmp_Id(id);
			PayRollDAO pd = new PayRollDAO();
			 List<Model_PayRoll> bonuslist=new ArrayList<Model_PayRoll>();
			 
			try {
				bonuslist =  pd.BonusToAssign(id);
				session.setAttribute("bonuslist", bonuslist);
				response.sendRedirect("AssignBonus.jsp");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		else if(flag.equals("bonus")){
			int empid = Integer.parseInt(request.getParameter("eid"));
			int payid = Integer.parseInt(request.getParameter("pid"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			
		
		request.setAttribute("eid", empid);
		request.setAttribute("pid", payid);
		request.setAttribute("fn",firstname);
		request.setAttribute("ln",lastname);
		//request.setAttribute("add",address);
		//request.setAttribute("email",email);
		//request.setAttribute("salary",salary);
		
		request.getRequestDispatcher("/BonusDetails.jsp").forward(request, response);
		// TODO Auto-generated method stub
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bonus = Integer.parseInt(request.getParameter("bonus"));
		int pid = Integer.parseInt(request.getParameter("pid"));
		int eid = Integer.parseInt(request.getParameter("eid"));
		Model_PayRoll modpay = new Model_PayRoll();
		modpay.setBonus(bonus);
		modpay.setPay_Id(pid);
		modpay.setEmp_Id(eid);
		PayRollDAO pd = new PayRollDAO();
		String msg;
		
		msg = pd.addBonus(modpay);
		
		if(msg.equals("suceess")){
			
			request.setAttribute("Bonus", "Successfully Bonus Added");
			request.getRequestDispatcher("/AssignBonus.jsp").forward(request, response);
			
		}
		else{
			request.setAttribute("error", "Error Occured");
			request.getRequestDispatcher("/BonusDetails.jsp").forward(request, response);
	
		}
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
