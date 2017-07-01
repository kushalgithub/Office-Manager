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
import Model.Model_Directory;

/**
 * Servlet implementation class DirectoryListController
 */
@WebServlet("/DirectoryListController")
public class DirectoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DirectoryListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag = request.getParameter("flag");
		HttpSession session = request.getSession();
		if(flag.equals("dirlist")){
			//HttpSession session = request.getSession();
			int id = (int) session.getAttribute("id");
			System.out.println(id);
			request.getRequestDispatcher("/DirectoryList.jsp").forward(request, response);
		}
		
		
		else if(flag.equals("listdir")){
			//HttpSession session = request.getSession();
			//int id = (int) session.getAttribute("id");
			//System.out.println(id);
			List<Model_Directory> publist = new ArrayList<Model_Directory>();
			DirectoryDAO dd = new DirectoryDAO();
			try {
				publist = dd.getPublicList();
				session.setAttribute("publist", publist);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.getRequestDispatcher("/PublicList.jsp").forward(request, response);
		}
		
		else if(flag.equals("prilistdir")){
			//HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			String idlike = "<"+id+">";
			System.out.println("dircontroller"+idlike);
			List<Model_Directory> privatelist = new ArrayList<Model_Directory>();
			DirectoryDAO dd = new DirectoryDAO();
			try {
				privatelist = dd.getPrivateList(idlike);
				session.setAttribute("privatelist", privatelist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("size of list:"+privatelist.size());
			request.getRequestDispatcher("/PrivateList.jsp").forward(request, response);
		}

		else if(flag.equals("prolistdir")){
			//HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			String idlike = "<"+id+">";
			System.out.println("dircontroller"+idlike);
			List<Model_Directory> protectedlist = new ArrayList<Model_Directory>();
			DirectoryDAO dd = new DirectoryDAO();
			try {
				protectedlist = dd.getProtectedList(idlike);
				session.setAttribute("protectedlist", protectedlist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("size of list:"+protectedlist.size());
			request.getRequestDispatcher("/ProtectedList.jsp").forward(request, response);
		}

		else if(flag.equals("deflistdir")){
			//HttpSession session = request.getSession();
			String id = session.getAttribute("id").toString();
			String idlike = "<"+id+">";
			System.out.println("dircontroller"+idlike);
			List<Model_Directory> defaultlist = new ArrayList<Model_Directory>();
			DirectoryDAO dd = new DirectoryDAO();
			try {
				defaultlist = dd.getDefaultList(idlike);
				session.setAttribute("defaultlist", defaultlist);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("size of list:"+defaultlist.size());
			request.getRequestDispatcher("/DefaultList.jsp").forward(request, response);
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
