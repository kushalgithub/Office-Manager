package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DirectoryDAO;

/**
 * Servlet implementation class AnotherTeamDetailsController
 */
@WebServlet("/AnotherTeamDetailsController")
public class AnotherTeamDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnotherTeamDetailsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int dirid = Integer.parseInt(request.getParameter("dirid"));
		String anotherempid = request.getParameter("emp");
		//System.out.println("dir id form controller:"+dirid);
		//System.out.println("another emp id from controller:"+anotherempid);
		HttpSession session = request.getSession();
		session.getAttribute("id");
		DirectoryDAO dd = new DirectoryDAO();
		String dirhira=null;
		try {
			dirhira =  dd.getDirectoryHirarchy(dirid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Previous hirarchy:"+dirhira);
		String anotherlist = dirhira + "<" +anotherempid +">";
		System.out.println("hirarchy to be added:"+dirhira);
		try {
			dd.addAnotherEmployee(anotherlist,dirid);
			request.setAttribute("anotheremp","Another team empoyee successfully added");
			request.getRequestDispatcher("/manager.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
