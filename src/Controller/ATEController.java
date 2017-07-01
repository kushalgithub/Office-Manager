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

import DAO.DirectoryDAO;
import DAO.RegistrationDAO;
import Model.Model_Directory;
import Model.Model_Registration;

/**
 * Servlet implementation class ATEController
 */
@WebServlet("/ATEController")
public class ATEController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ATEController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		String flag = request.getParameter("flag");
		
		
		if(flag.equals("pro")){
			//HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			String idlike = "<"+id+">";
			System.out.println("dircontroller"+idlike);
			List<Model_Directory> anotherlist = new ArrayList<Model_Directory>();
			//List<Model_Registration> reglist = new ArrayList<Model_Registration>();
			
			/*RegistrationDAO reg = new RegistrationDAO(); 
			try {
				reglist = reg.getAllActiveEmployees();
				session.setAttribute("reglist", reglist);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}*/
			
			DirectoryDAO dd = new DirectoryDAO();
			try {
				anotherlist = dd.getProtectedList(idlike);
				session.setAttribute("anotherlist", anotherlist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("size of list:"+anotherlist.size());
			request.getRequestDispatcher("/AnotherTeamList.jsp").forward(request, response);
		}
		
		else if(flag.equals("atedetail")){
			
			int id = (int) session.getAttribute("id");
			String dirname = request.getParameter("dirname");
			String dirtype = request.getParameter("dirtype");
			int dirid = Integer.parseInt(request.getParameter("dirid"));
			//int anotherempid = Integer.parseInt(request.getParameter("emp"));
			//System.out.println(anotherempid);
			List<Model_Registration> reglist = new ArrayList<Model_Registration>();
			
			RegistrationDAO reg = new RegistrationDAO(); 
			try {
				reglist = reg.getAllActiveEmployees();
				session.setAttribute("reglist", reglist);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			request.setAttribute("dirname", dirname);
			request.setAttribute("dirtype", dirtype);
			session.setAttribute("dirid", dirid);
			//request.setAttribute("anotherempid", anotherempid);
			request.getRequestDispatcher("/AnotherTeamDetails.jsp").forward(request, response);
			
			
			
			
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
