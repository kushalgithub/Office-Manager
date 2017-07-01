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

import DAO.LeaveDAO;
import Model.Model_LeaveRequest;
import Model.Model_Registration;

/**
 * Servlet implementation class LeaveRequestManagerController
 */
@WebServlet("/LeaveRequestManagerController")
public class LeaveRequestManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeaveRequestManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		if(flag.equals("list")){
			HttpSession session=request.getSession();
			int id = (int) session.getAttribute("id");
			System.out.println(id);
			 Model_LeaveRequest modlea = new Model_LeaveRequest();
			 //modlea.setEmp_Id(id);
			LeaveDAO leavedao = new LeaveDAO();
			 List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
		
		try {
		leavelist= leavedao.ShowLeavesToManager(id);
		//System.out.println("Size Of List:"+inactivelist.size());
		session.setAttribute("leavelist", leavelist);
		response.sendRedirect("LeaveRequestManager.jsp");
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		
	 }

		response.getWriter().append("Served at: ").append(request.getContextPath());
		}
		
		if(flag.equals("Approvelist")){
			HttpSession session=request.getSession();
			int id = Integer.parseInt(request.getParameter("id"));
			int id1 = Integer.parseInt(request.getParameter("empid"));
			System.out.println(id);
			// Model_LeaveRequest modlea = new Model_LeaveRequest();
			 //modlea.setEmp_Id(id);
			int leavedays = Integer.parseInt(request.getParameter("leavedays"));
			 LeaveDAO leavedao = new LeaveDAO();
			 List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
			 LeaveDAO ld = new LeaveDAO();
			 Model_Registration modreg = new Model_Registration();
			 int var = 0;
			 try {
				 var = ld.AvailLeaves(id1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 int difference = var - leavedays;
			 System.out.println("controller var:"+var);
			 System.out.println("controller leavedays:"+leavedays);
			 System.out.println("controller difference:"+difference);
		try {
		leavedao.ApproveLeaves(id);
		leavedao.updatetotalleaves(id1,difference);
		//System.out.println("Size Of List:"+inactivelist.size());
		session.setAttribute("leavelist", leavelist);
		response.sendRedirect("LeaveRequestManager.jsp");
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		
	 }

		response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		if(flag.equals("Discardlist")){
			HttpSession session=request.getSession();
			int id = Integer.parseInt(request.getParameter("id"));
			System.out.println(id);
			// Model_LeaveRequest modlea = new Model_LeaveRequest();
			 //modlea.setEmp_Id(id);
			LeaveDAO leavedao = new LeaveDAO();
			List<Model_LeaveRequest> leavelist=new ArrayList<Model_LeaveRequest>();
		
		try {
		leavelist = leavedao.DiscardLeaves(id);
		session.setAttribute("leavelist", leavelist);
		response.sendRedirect("LeaveRequestManager.jsp");} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		
	 }

		response.getWriter().append("Served at: ").append(request.getContextPath());
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
